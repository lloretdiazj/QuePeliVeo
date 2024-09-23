package com.quepeliveo.ui.features.inicio

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quepeliveo.data.PeliculaRepository
import com.quepeliveo.data.converters.toPeliculaUiState
import com.quepeliveo.data.services.ApiServicesException
import com.quepeliveo.ui.features.inicio.uistates.ConsultaUiState
import com.quepeliveo.ui.features.inicio.uistates.PeliculaUiState
import com.quepeliveo.ui.features.inicio.uistates.ValidacionConsultaUiState
import com.quepeliveo.ui.features.inicio.uistates.ValidadorConsulta
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@SuppressLint("MutableCollectionMutableState")
@HiltViewModel
class InicioViewModel @Inject constructor(
    private val peliculaRepository: PeliculaRepository,
    private val validadorConsulta: ValidadorConsulta
) : ViewModel() {

    var listaPeliculas by mutableStateOf(mutableListOf<PeliculaUiState>().toMutableStateList())
        private set

    var consulta by mutableStateOf(ConsultaUiState())
        private set

    var verDialogoPelicula by mutableStateOf(false)
        private set

    var estanPeliculasCargadas by mutableStateOf(true)
        private set

    var peliculaSeleccionada by mutableStateOf(PeliculaUiState())
        private set
    var verDialogoInformacion by mutableStateOf(false)
        private set

    var mensajeSnackBarState by mutableStateOf("")
        private set

    var mostrarSnackBar by mutableStateOf(false)
        private set

    var validacionConsultaUiState by mutableStateOf(ValidacionConsultaUiState())
        private set

    var botonState by mutableStateOf(false)
        private set

    init {
        consulta = ConsultaUiState(prompt = "", numero = "0")
        validacionConsultaUiState = ValidacionConsultaUiState(
            validacionNumeroPeliculas = validadorConsulta.validacionNumeroPeliculas.valida("1"),
            validacionPrompt = validadorConsulta.validacionPrompt.valida("Hay 0 caracteres")
        )
        botonState = false
    }


    suspend fun listaPeliculas(prompt: String, numero: String) =
        peliculaRepository.get(prompt, numero)
            .toMutableList().map { it.toPeliculaUiState() }.toMutableStateList()

    fun onInicioEvent(event: InicioEvent) {
        when (event) {
            is InicioEvent.OnClickAction -> {

                if (!validadorConsulta.validacionPrompt.valida(consulta.prompt).hayError &&
                    !validadorConsulta.validacionNumeroPeliculas.valida(consulta.numero).hayError
                ) {
                    viewModelScope.launch {
                        try {
                            estanPeliculasCargadas = false
                            listaPeliculas.forEach {
                                val copiaLista = listaPeliculas.toMutableList()
                                for (pelicula in copiaLista) {
                                    listaPeliculas.remove(pelicula)
                                }
                            }
                            listaPeliculas = listaPeliculas(consulta.prompt, consulta.numero)

                            estanPeliculasCargadas = true
                        } catch (e: ApiServicesException) {

                            estanPeliculasCargadas = true
                            mensajeSnackBarState = "No se han podido obtener resultados..."
                            mostrarSnackBar = true
                        }
                    }
                }
            }

            is InicioEvent.OnClickRefresh -> {
                listaPeliculas.forEach() {
                    val copiaLista = listaPeliculas.toMutableList()
                    for (pelicula in copiaLista) {
                        listaPeliculas.remove(pelicula)
                    }


                }

                consulta = consulta.copy(prompt = "", numero = "0")
                validacionConsultaUiState = ValidacionConsultaUiState(
                    validacionNumeroPeliculas = validadorConsulta.validacionNumeroPeliculas.valida(
                        "6"
                    ),
                    validacionPrompt = validadorConsulta.validacionPrompt.valida("Hay 6 caracteres")
                )
                botonState = false
            }

            is InicioEvent.OnDismissDialogoPelicula -> {
                verDialogoPelicula = false
            }

            is InicioEvent.OnClickPelicula -> {
                peliculaSeleccionada = peliculaSeleccionada.copy(
                    poster = listaPeliculas[event.posicionPelicula].poster,
                    nombre = listaPeliculas[event.posicionPelicula].nombre,
                    anyo = listaPeliculas[event.posicionPelicula].anyo,
                    sinopsis = listaPeliculas[event.posicionPelicula].sinopsis,
                    IMDB = listaPeliculas[event.posicionPelicula].IMDB,
                    generos = listaPeliculas[event.posicionPelicula].generos,
                    puntuacion = listaPeliculas[event.posicionPelicula].puntuacion

                )

                verDialogoPelicula = true
            }
//
//            is InicioEvent.OnNumeroPeliculasChanged -> {
//
//                consulta = consulta.copy(numero = event.numero)
//
//                validacionConsultaUiState = validacionConsultaUiState.copy(
//                    validacionNumeroPeliculas = validadorConsulta.validacionNumeroPeliculas.valida(
//                        event.numero
//                    )
//                )
//
//                botonState = !validacionConsultaUiState.validacionNumeroPeliculas.hayError &&
//                        !validacionConsultaUiState.validacionPrompt.hayError
//
//            }

            is InicioEvent.OnPromptChanged -> {
                consulta = consulta.copy(prompt = event.prompt)

                validacionConsultaUiState = validacionConsultaUiState.copy(
                    validacionPrompt = validadorConsulta.validacionPrompt.valida(event.prompt)
                )

                botonState = !validacionConsultaUiState.validacionNumeroPeliculas.hayError &&
                        !validacionConsultaUiState.validacionPrompt.hayError
            }

            is InicioEvent.OnClickMas -> {
                if (consulta.numero.toInt() < 6) {
                    consulta = consulta.copy(numero = (consulta.numero.toInt() + 1).toString())
                    validacionConsultaUiState = validacionConsultaUiState.copy(
                        validacionNumeroPeliculas = validadorConsulta.validacionNumeroPeliculas.valida(
                            consulta.numero
                        )
                    )


                }

                botonState = !validacionConsultaUiState.validacionNumeroPeliculas.hayError &&
                        !validacionConsultaUiState.validacionPrompt.hayError

            }

            is InicioEvent.OnClickMenos -> {

                if (consulta.numero.toInt() > 0) {
                    consulta = consulta.copy(numero = (consulta.numero.toInt() - 1).toString())
                    validacionConsultaUiState = validacionConsultaUiState.copy(
                        validacionNumeroPeliculas = validadorConsulta.validacionNumeroPeliculas.valida(
                            consulta.numero
                        )
                    )

                    botonState =
                        !validacionConsultaUiState.validacionNumeroPeliculas.hayError &&
                                !validacionConsultaUiState.validacionPrompt.hayError
                }
            }

            is InicioEvent.OnDismissDialogoInfo -> {
                verDialogoInformacion = false
            }

            is InicioEvent.OnClickInfo -> {
                verDialogoInformacion = true
            }


        }
    }
}

