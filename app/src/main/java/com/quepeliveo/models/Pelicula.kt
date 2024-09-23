package com.quepeliveo.models

data class Pelicula(
    val poster: String = "",
    val nombre: String = "",
    val anyo: String = "",
    val sinopsis: String = "",
    val IMDB: String = "",
    val puntuacion: String = "",
    val generos: List<String> = emptyList(),
)
