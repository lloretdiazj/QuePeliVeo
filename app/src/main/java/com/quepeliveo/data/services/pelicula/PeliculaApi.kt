package com.quepeliveo.data.services.pelicula

data class PeliculaApi (
    val poster: String = "",
    val nombre: String = "",
    val anyo: String = "",
    val sinopsis: String = "",
    val IMDB: String = "",
    val puntuacion: String = "",
    val generos: List<String> = emptyList(),
)