package com.quepeliveo.di

import com.quepeliveo.data.services.pelicula.PeliculaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

        val timeout = 10L
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ) : Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("") // Insertar IP dónde esté backend
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun providePeliculaService(
        retrofit: Retrofit
    ): PeliculaService = retrofit.create(PeliculaService::class.java)
}