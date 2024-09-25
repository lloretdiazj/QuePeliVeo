package com.quepeliveo.views


import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material3.ExperimentalMaterial3Api
import com.quepeliveo.ui.features.inicio.Inicio
import com.quepeliveo.ui.features.inicio.InicioViewModel
import com.quepeliveo.ui.theme.QuePeliVeoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            QuePeliVeoTheme {

                val inicioViewModel by viewModels<InicioViewModel>()

                //Cuando hayan más pantallas se deberá agregar la navegación.

                Inicio(
                    listaPeliculas = inicioViewModel.listaPeliculas,
                    peliculaSeleccionada = inicioViewModel.peliculaSeleccionada,
                    consultaUiState = inicioViewModel.consulta,
                    onInicioEvent = inicioViewModel::onInicioEvent,
                    estanCargadas = inicioViewModel.estanPeliculasCargadas,
                    verDialogoPelicula = inicioViewModel.verDialogoPelicula,
                    verDialogoInfo = inicioViewModel.verDialogoInformacion,
                    mensajeSnack = inicioViewModel.mensajeSnackBarState,
                    mostrarSnack = inicioViewModel.mostrarSnackBar,
                    estadoBoton = inicioViewModel.botonState,
                    validacionConsulta = inicioViewModel.validacionConsultaUiState
                )

            }
        }
    }
}

