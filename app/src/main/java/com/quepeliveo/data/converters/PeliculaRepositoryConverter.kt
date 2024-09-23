package com.quepeliveo.data.converters

import com.quepeliveo.data.services.pelicula.PeliculaApi
import com.quepeliveo.models.Pelicula
import com.quepeliveo.ui.features.inicio.uistates.PeliculaUiState

fun PeliculaApi.toPelicula(): Pelicula =
    Pelicula(
        poster = this.poster,
        nombre = this.nombre,
        anyo = this.anyo,
        sinopsis = this.sinopsis,
        IMDB = this.IMDB,
        generos = this.generos,
        puntuacion = this.puntuacion
    )

fun PeliculaApi.toPeliculaApiApi(): PeliculaApi =
    PeliculaApi(
        poster = this.poster,
        nombre = this.nombre,
        anyo = this.anyo,
        sinopsis = this.sinopsis,
        IMDB = this.IMDB,
        generos = this.generos,
        puntuacion = this.puntuacion
    )

fun Pelicula.toPeliculaUiState(): PeliculaUiState =
    PeliculaUiState(
        poster = this.poster,
        nombre = this.nombre,
        anyo = this.anyo,
        sinopsis = this.sinopsis,
        IMDB = this.IMDB,
        generos = this.generos,
        puntuacion = this.puntuacion
    )

fun PeliculaUiState.toPelicula(): Pelicula =
    Pelicula(
        poster = this.poster,
        nombre = this.nombre,
        anyo = this.anyo,
        sinopsis = this.sinopsis,
        IMDB = this.IMDB,
        generos = this.generos,
        puntuacion = this.puntuacion
    )