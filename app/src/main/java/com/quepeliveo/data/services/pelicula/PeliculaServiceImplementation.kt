package com.quepeliveo.data.services.pelicula

import android.util.Log
import com.quepeliveo.data.services.ApiServicesException
import javax.inject.Inject

class PeliculaServiceImplementation @Inject constructor(
    private val peliculaService: PeliculaService
) {
    private val logTag: String = "OkHttp"
    suspend fun get(prompt: String, numero: String): List<PeliculaApi> {
        val mensajeError = "No se han podido obtener los peliculas"
        try {
            val response = peliculaService.get(prompt, numero)
            if (response.isSuccessful) {
                Log.d(logTag, response.toString())
                val dato = response.body()
                return dato ?: throw ApiServicesException("No hay datos de gastos")
            } else {
                val body = response.errorBody()?.string()
                Log.e(logTag, "$mensajeError (código ${response.code()}): $this\n${body}")
                throw ApiServicesException(mensajeError)
            }
        } catch (e: Exception) {
            Log.e(logTag, "Error: ${e.localizedMessage}")
            throw ApiServicesException(mensajeError)
        }
    }
}