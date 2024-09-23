package com.quepeliveo.ui.features.inicio.uistates

data class PeliculaUiState(
    val poster: String = "",
    val nombre: String = "Título no obtenido",
    val anyo: String = "Año no obtenido",
    val sinopsis: String = "Sinopsis no obtenida",
    val IMDB: String = "",
    val puntuacion: String = "Puntuación no obtenida",
    val generos: List<String> = listOf("Género no obtenido"),
)
