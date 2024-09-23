package com.quepeliveo.data

import com.quepeliveo.data.converters.toPelicula
import com.quepeliveo.data.services.pelicula.PeliculaServiceImplementation
import com.quepeliveo.models.Pelicula
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PeliculaRepository @Inject constructor(
    private val proveedorPeliculas: PeliculaServiceImplementation
) {
    suspend fun get(prompt: String, numero: String): List<Pelicula> =
        withContext(Dispatchers.IO) { proveedorPeliculas.get(prompt, numero).toMutableList().map { it.toPelicula() } }
}