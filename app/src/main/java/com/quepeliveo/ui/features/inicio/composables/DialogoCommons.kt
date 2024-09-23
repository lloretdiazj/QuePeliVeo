package com.quepeliveo.ui.features.inicio.composables

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.quepeliveo.ui.features.inicio.InicioEvent
import com.quepeliveo.ui.features.inicio.components.TextoGenerosPuntuacion
import com.quepeliveo.ui.features.inicio.components.amazonEmber
import com.quepeliveo.ui.features.inicio.uistates.PeliculaUiState
import com.quepeliveo.ui.theme.QuePeliVeoTheme
import com.quepeliveo.utilities.compartirContenido


@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun DialogoPelicula(
    pelicula: PeliculaUiState,
    darkTheme: Boolean = isSystemInDarkTheme(),
    onInicioEvent: (InicioEvent) -> Unit,
    contexto: Context = LocalContext.current
) =
    AlertDialog(
        modifier = Modifier,

        text = {
            val colorLetras = if (darkTheme) Color.White else Color.Black

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Row() {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.size(100.dp)
                    ) {
                        Text(
                            text = pelicula.nombre,
                            color = colorLetras,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = pelicula.anyo,
                            color = colorLetras,
                            fontSize = 14.sp,
                        )
                    }

                    Spacer(
                        modifier = Modifier.width(50.dp)
                    )


                    Image(
                        painter = rememberAsyncImagePainter(model = pelicula.poster),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(16.dp)
                            )
                            .size(100.dp),

                        )
                }
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                TextoGenerosPuntuacion(
                    puntuacion = pelicula.puntuacion,
                    color = colorLetras,
                    generos = pelicula.generos,
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                val scrollState = rememberScrollState()
                Text(
                    text = pelicula.sinopsis,
                    color = colorLetras,
                    textAlign = TextAlign.Justify,
                    style = TextStyle(
                        fontSize = 15.sp,
                        lineHeight = 20.sp
                    ),
                    modifier = Modifier.verticalScroll(scrollState)
                )
            }
        },
        dismissButton = {
            IconButton(
                onClick = {
                    compartirContenido(
                        context = contexto,
                        contenido = "QuePeliVeo me ha recomendado esta película: ${pelicula.IMDB}, te apetece verla? "
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Compartir"
                )
            }
        },
        onDismissRequest = { onInicioEvent(InicioEvent.OnDismissDialogoPelicula) },
        confirmButton = {
            TextButton(
                onClick = { onInicioEvent(InicioEvent.OnDismissDialogoPelicula) }
            ) {
                Text("Vale!")
            }
        }
    )


@Composable
fun DialogoInformación(
    onInicioEvent: (InicioEvent) -> Unit,
    darkTheme: Boolean = isSystemInDarkTheme(),
) =
    AlertDialog(
        modifier = Modifier,

        text = {
            val colorLetras = if (darkTheme) Color.White else Color.Black
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text("Made with ", color = colorLetras)
                Icon(
                    imageVector = Icons.Filled.Favorite,
                    contentDescription = "Heart icon",
                    tint = Color(0xff5b3dd4)
                )
                Text("by Josep Lloret & Diego Valdés.", color = colorLetras)
                Text("[-Infinexum Team-]", color = colorLetras)
                Spacer(
                    modifier = Modifier.height(30.dp)
                )
                Text(
                    text =
                        "Ten en cuenta que las recomendaciones son proporcionadas por una IA y " +
                            "que la calidad de las mismas dependerá de la información " +
                            "que nos proporciones.",
                    color = colorLetras,
                    fontSize = 13.sp,
                    fontFamily = amazonEmber,
                    textAlign = TextAlign.Justify,

                    )
                Spacer(
                    modifier = Modifier.height(10.dp)
                )
                Text(
                    text =
                    "Estos datos se han obtenido de TheMovieDataBase (TMDB).",
                    color = colorLetras,
                    fontSize = 13.sp,
                    fontFamily = amazonEmber,
                    textAlign = TextAlign.Justify,

                    )


            }
        },
        onDismissRequest = { onInicioEvent(InicioEvent.OnDismissDialogoInfo) },
        confirmButton = {
            TextButton(
                onClick = { onInicioEvent(InicioEvent.OnDismissDialogoInfo) }
            ) {
                Text("Vale!")
            }
        }
    )


@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun DialogoPeliculaPreview() {
    QuePeliVeoTheme {
        DialogoInformación(
            onInicioEvent = {}
        )
    }
}

