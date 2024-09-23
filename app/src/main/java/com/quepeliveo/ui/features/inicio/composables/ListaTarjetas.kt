package com.quepeliveo.ui.features.inicio.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.quepeliveo.ui.features.inicio.InicioEvent
import com.quepeliveo.ui.features.inicio.uistates.PeliculaUiState

@Composable
fun ListaTarjetas(
    listaPeliculas: List<PeliculaUiState>,
    paddingValues: PaddingValues,
    onInicioEvent: (InicioEvent) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .background(
                Color.Transparent
            ),
        contentPadding = PaddingValues(
            horizontal = 8.dp,

        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        items(listaPeliculas) { pelicula ->
            TarjetaPeliculaCommon(
                pelicula = pelicula,
                posicionLista = listaPeliculas.indexOf(pelicula),
                onInicioEvent = onInicioEvent
            )
        }
    }
}

