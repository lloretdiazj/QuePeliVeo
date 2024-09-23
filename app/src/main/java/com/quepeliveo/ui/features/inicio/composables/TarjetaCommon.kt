package com.quepeliveo.ui.features.inicio.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.quepeliveo.ui.features.inicio.InicioEvent
import com.quepeliveo.ui.features.inicio.components.ButtonEnlace
import com.quepeliveo.ui.features.inicio.components.ImagenTajeta
import com.quepeliveo.ui.features.inicio.components.TextoAnyo
import com.quepeliveo.ui.features.inicio.components.TextoGenerosPuntuacion
import com.quepeliveo.ui.features.inicio.components.TextoSinopsis
import com.quepeliveo.ui.features.inicio.components.TextoTitulo
import com.quepeliveo.ui.features.inicio.uistates.PeliculaUiState
import com.quepeliveo.utilities.abreIMDB

@Composable
fun TarjetaPeliculaCommon(
//    poster: String,
//    titulo: String,
//    anyo: String,
//    sinopsis: String,
    pelicula: PeliculaUiState,
    darkTheme: Boolean = isSystemInDarkTheme(),
//    enlaceIMDB: String,
    posicionLista: Int,
    onInicioEvent: (InicioEvent) -> Unit
) {

    val colorLetras = if (darkTheme) Color.White else Color.Black
    val colorFondoTarjetas = if (!darkTheme) Color.White else Color(0xff343a40)

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), modifier = Modifier
            .height(400.dp),
        colors = CardColors(
            colorFondoTarjetas,
            colorFondoTarjetas,
            colorFondoTarjetas,
            colorFondoTarjetas,
        )

    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .border(1.dp, Color.Transparent, shape = MaterialTheme.shapes.large)
                .padding(5.dp)
                .clickable { onInicioEvent(InicioEvent.OnClickPelicula(posicionLista)) }
        ) {
            ImagenTajeta(
                enlaceImagen = pelicula.poster
            )
            Spacer(modifier = Modifier.padding(5.dp))
            TextoTitulo(
                texto = pelicula.nombre,
                color = colorLetras,

                )

            TextoAnyo(
                texto = pelicula.anyo,
                color = colorLetras,
            )
            Spacer(modifier = Modifier.padding(5.dp))
            TextoGenerosPuntuacion(
                puntuacion = pelicula.puntuacion,
                color = colorLetras,
                generos = pelicula.generos,
            )
//            TextoSinopsis(
//                texto = pelicula.sinopsis,
//                color = colorLetras,
//            )

            Spacer(modifier = Modifier.padding(5.dp))
            val context = LocalContext.current

            ButtonEnlace(
                onClick = {
                    context.abreIMDB(pelicula.IMDB)
                }
            )
        }
    }
}

