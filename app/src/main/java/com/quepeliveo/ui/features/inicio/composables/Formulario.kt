package com.quepeliveo.ui.features.inicio.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.sharp.KeyboardArrowDown
import androidx.compose.material.icons.sharp.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quepeliveo.R
import com.quepeliveo.models.Pelicula
import com.quepeliveo.ui.features.inicio.InicioEvent
import com.quepeliveo.ui.features.inicio.components.ButtonBuscar
import com.quepeliveo.ui.features.inicio.components.OutlinedTextFieldConError
import com.quepeliveo.ui.features.inicio.components.OutlinedTextFieldConErrorNumerico
import com.quepeliveo.ui.features.inicio.components.montserrat
import com.quepeliveo.ui.features.inicio.uistates.ConsultaUiState
import com.quepeliveo.utilities.validacion.Validacion


@Composable
fun Formulario(
    consultaUiState: ConsultaUiState,
    paddingValue: PaddingValues,
    hayContenido: Boolean,
    estadoBoton: Boolean,
    validacionPrompt: Validacion,
    validacionNumeroPelicula: Validacion,
    inicioEvent: (InicioEvent) -> Unit,
    onMostrarSnack: () -> Unit
) {

    val focusManager = LocalFocusManager.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                PaddingValues(
                    start = 5.dp,
                    end = 5.dp,
                    top = paddingValue.calculateTopPadding(),
                    bottom = 0.dp
                )
            )
    ) {

        if (!hayContenido) {

            Image(
                painter = painterResource(id = R.drawable.qpv),
                contentDescription = "Logo",
                modifier = Modifier
//                    .padding(0.dp)
//                    .size(200.dp)
                    .width(300.dp)
//                    .height(50.dp)
                    .clip(RectangleShape)
//                    .border(1.dp, Color.Black),
            )

            Text(
                "QUEPELIVEO",
                fontWeight = FontWeight.Bold,
                fontFamily = montserrat,
                fontStyle = FontStyle.Italic,
                color = Color.Black,
                fontSize = 30.sp
            )
            Text(
                "DON'T WASTE, JUST FUN!",

                fontFamily = montserrat,
                fontStyle = FontStyle.Italic,
                color = Color.Black,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
//                .padding(5.dp)
        ) {

            OutlinedTextFieldConError(
                textoState = consultaUiState.prompt,
                onValueChange = {
                    inicioEvent(InicioEvent.OnPromptChanged(it))
                },
                textoPista = "Cuéntame... Qué quieres ver? ",
                validacionState = validacionPrompt,
                modifier = Modifier
                    .fillMaxWidth()
//                    .width(250.dp)
                    .background(
                        Color.Transparent
                    )

            )
            Text(
                text = "Número Películas",
                fontSize = 15.sp,
                color = Color.Black,
                fontFamily = montserrat,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ){
                IconButton(
//                    modifier = Modifier.width(50.dp),
                    onClick = {
                        inicioEvent(InicioEvent.OnClickMenos(consultaUiState.numero))
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(200.dp),
                        imageVector = Icons.Sharp.KeyboardArrowDown,
                        contentDescription = "Menu",
                        tint = Color.Black
                    )
                }

                Text(
                    text = consultaUiState.numero,
                    fontSize = 25.sp,
                    color = Color.Black,
                    fontFamily = montserrat,
                    fontWeight = FontWeight.Bold
                )

                IconButton(
                    onClick = {
                        inicioEvent(InicioEvent.OnClickMas(consultaUiState.numero))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Sharp.KeyboardArrowUp,
                        contentDescription = "Menu",
                        modifier = Modifier.size(200.dp),
                        tint = Color.Black
                    )
                }
            }

//            Spacer(modifier = Modifier.width(5.dp))



//            OutlinedTextFieldConErrorNumerico(
//                textoState = consultaUiState.numero,
//                onValueChange = { inicioEvent(InicioEvent.OnNumeroPeliculasChanged(it)) },
//                textoPista = "Nº.",
//                validacionState = validacionNumeroPelicula,
//                modifier = Modifier
////                    .width(100.dp)
//                    .background(
//                        Color.Transparent
//                    )
//
//            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        ButtonBuscar(
            onClick = {
                focusManager.clearFocus()
                inicioEvent(InicioEvent.OnClickAction)
                onMostrarSnack()
            },
            estadoBoton = estadoBoton,
        )
    }
}


