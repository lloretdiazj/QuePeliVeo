package com.quepeliveo.data.services.pelicula

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface PeliculaService {


    @GET("recomendador")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun get(@Query("prompt") prompt: String, @Query("numero") numero: String): Response<List<PeliculaApi>>




}