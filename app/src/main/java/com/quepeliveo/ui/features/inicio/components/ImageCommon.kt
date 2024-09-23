package com.quepeliveo.ui.features.inicio.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.quepeliveo.R

@Composable
fun ImagenTajeta(
    enlaceImagen: String
) {

        val enlace =
            if(enlaceImagen.isEmpty())
                painterResource(id = R.drawable.sin_poster)
            else
                rememberAsyncImagePainter(model = enlaceImagen)

        Image(
            painter = enlace,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
                .size(200.dp),

            )
}