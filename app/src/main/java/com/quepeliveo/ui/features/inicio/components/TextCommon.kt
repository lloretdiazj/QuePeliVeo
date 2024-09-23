package com.quepeliveo.ui.features.inicio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TextoTitulo(
    texto: String,
    color: Color,
    tamanyoLetra: Int = 23,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = " $texto",
            color = color,
            fontSize = tamanyoLetra.sp,
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun TextoAnyo(
    texto: String,
    color: Color,
    tamañoLetra: Int = 17,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = " $texto",
            color = color,
            fontSize = tamañoLetra.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun TextoSinopsis(
    texto: String,
    color: Color,
    tamañoLetra: Int = 15,
) {
    Box(
        modifier = Modifier.height(100.dp)
    ) {
        Text(
            text = " $texto",
            color = color,
            fontSize = tamañoLetra.sp,
            textAlign = TextAlign.Justify,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth(),
            lineHeight = 20.sp,
            maxLines = 8,
            minLines = 5
        )
    }
}

@Composable
fun TextoGenerosPuntuacion(
    puntuacion: String,
    generos: List<String>,
    color: Color,
    tamanyoLetra: Int = 12,
) {
    Column(
//        modifier = Modifier.height(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Menu",
                tint = Color(0xffffca2c),
                modifier = Modifier.height(20.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = puntuacion,
                color = color,
                fontSize = tamanyoLetra.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
//            overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
//            lineHeight = 20.sp,
//            maxLines = 5
            )
        }

//        Spacer(modifier = Modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(start = 2.dp)
        ) {
            Image(
                painter = painterResource(id = com.quepeliveo.R.drawable.aplicacion),
                contentDescription = "Menu",
//                tint = Color.Black,
                modifier = Modifier.height(15.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = " ${generos.joinToString(separator = ", ", postfix = if(generos.size > 1) "." else "")}",
                color = color,
                fontSize = tamanyoLetra.sp,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth(),
                lineHeight = 15.sp,
                maxLines = 1
            )
        }
    }
}
