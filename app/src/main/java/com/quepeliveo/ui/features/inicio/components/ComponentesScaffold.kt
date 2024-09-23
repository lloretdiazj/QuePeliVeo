package com.quepeliveo.ui.features.inicio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.quepeliveo.R
import com.quepeliveo.ui.features.inicio.InicioEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(
    comportamientoAnteScroll: TopAppBarScrollBehavior,
    hayContenido: Boolean,
    onInicioEvent: (InicioEvent) -> Unit
) = TopAppBar(
    modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent),
//        .height(50.dp)
    colors = TopAppBarColors(
        Color.Transparent,
        Color.Transparent,
        Color.Transparent,
        Color.Transparent,
        Color.Transparent
    ),
    actions = {
        IconButton(
            onClick = {
                onInicioEvent(InicioEvent.OnClickInfo)
            }) {
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = "Menu",
                tint = Color.Black
            )
        }
    },
    title = {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp)
        ) {

            if (hayContenido)
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.qpv),
                    contentDescription = "Logo",
                    modifier = Modifier.size(80.dp),
                    tint = Color.Black
                )
        }
    },
    scrollBehavior = comportamientoAnteScroll,
)

