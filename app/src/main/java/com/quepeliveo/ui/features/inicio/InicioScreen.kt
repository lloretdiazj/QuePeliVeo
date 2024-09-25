package com.quepeliveo.ui.features.inicio

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quepeliveo.ui.features.inicio.components.BarraSuperior
import com.quepeliveo.ui.features.inicio.components.amazonEmber
import com.quepeliveo.ui.features.inicio.composables.DialogoInformación
import com.quepeliveo.ui.features.inicio.composables.DialogoPelicula
import com.quepeliveo.ui.features.inicio.composables.Formulario
import com.quepeliveo.ui.features.inicio.composables.ListaTarjetas
import com.quepeliveo.ui.features.inicio.uistates.ConsultaUiState
import com.quepeliveo.ui.features.inicio.uistates.PeliculaUiState
import com.quepeliveo.ui.features.inicio.uistates.ValidacionConsultaUiState
import com.quepeliveo.utilities.validacion.Validacion
import kotlinx.coroutines.launch


@RequiresApi(Build.VERSION_CODES.P)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(
    listaPeliculas: List<PeliculaUiState>,
    peliculaSeleccionada: PeliculaUiState,
    consultaUiState: ConsultaUiState,
    verDialogoPelicula: Boolean,
    verDialogoInfo: Boolean,
    estanCargadas: Boolean = true,
    mensajeSnack: String,
    mostrarSnack: Boolean,
    estadoBoton: Boolean,
    validacionConsulta: ValidacionConsultaUiState,
    onInicioEvent: (InicioEvent) -> Unit,
) {
    val comportamientoAnteScroll = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val onMostrarSnack: () -> Unit = {

        scope.launch {

            if (mostrarSnack) {
                snackBarHostState.showSnackbar(
                    message = mensajeSnack,
                    duration = SnackbarDuration.Short,
                    withDismissAction = true
                )
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            val focusManager = LocalFocusManager.current
            if (listaPeliculas.isNotEmpty()) {
                FloatingActionButton(
                    onClick = {
                        focusManager.clearFocus()
                        onInicioEvent(InicioEvent.OnClickRefresh) },
                    containerColor = Color(0xff343a40),
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                ) {
                    Icon(Icons.Filled.Refresh, "Localized description")
                }
            }
        },
        snackbarHost = { SnackbarHost(snackBarHostState) },
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(comportamientoAnteScroll.nestedScrollConnection),
        topBar = {
            BarraSuperior(
                comportamientoAnteScroll = comportamientoAnteScroll,
                hayContenido = listaPeliculas.isNotEmpty(),
                onInicioEvent = onInicioEvent
            )
        },
        content = { paddingValues ->
            Box() {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()

                        .background(
                            Brush.linearGradient(
                                colors = listOf(Color(0xffffecd2), Color(0xfffcb69f))
                            )
                        )
                ) {
                    Formulario(
                        hayContenido = listaPeliculas.isNotEmpty(),
                        paddingValue = paddingValues,
                        consultaUiState = consultaUiState,
                        inicioEvent = onInicioEvent,
                        onMostrarSnack = onMostrarSnack,
                        estadoBoton = estadoBoton,
                        validacionPrompt = validacionConsulta.validacionPrompt,
                        validacionNumeroPelicula = validacionConsulta.validacionNumeroPeliculas
                    )

                    if (!estanCargadas) {
                        Spacer(modifier = Modifier.height(40.dp))
                        CircularProgressIndicator(
                            modifier = Modifier.width(54.dp),
                            color = Color.Black,
                            trackColor = Color.White,
                            strokeWidth = 2.dp
                        )
                    }

                    if (listaPeliculas.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(16.dp))
                        ListaTarjetas(
                            listaPeliculas = listaPeliculas,
                            paddingValues = paddingValues,
                            onInicioEvent = onInicioEvent
                        )
                    }
                }
                if (verDialogoPelicula) {
                    DialogoPelicula(
                        pelicula = peliculaSeleccionada,
                        onInicioEvent = onInicioEvent
                    )
                }

                if (verDialogoInfo) {
                    DialogoInformación(
                        onInicioEvent = onInicioEvent
                    )
                }
            }
        }
    )
}