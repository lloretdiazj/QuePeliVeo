# QuePeliVeo

## Descripción.

QuePeliVeo es una aplicación con utilidad para recomendar películas a partir de una descripción y el número de películas que queremos recibir. Además si nos te ha gustado la recomendación puedes compartirla con alquien para verla, también tiene sinopsis, año, géneros, poster y enlace de IMDB.

## Tecnología.

Esta desarrollada con Kotlin en Jetpack Compose, usando Android Studio, en el tenemos una interfaz y lógica de negocio capacitada para conectarse al servidor donde se encuentra nuestra aplicación Bakcend. Este está desarrollado en Python usando Flask, conectandonos a una Inteligencia Artificial alojada en local, de forma que con la descripción obtenida por el usuario le consulta y esta devuelve un resultado de películas, una vez obtenidos los títulos la aplicación Backend es el encargado de procesar y obtener la infomación de cada película para así ser devuelta a la App y esta mostrarlos.

## Desarrollo.

App - Jetpack Compose, Kotlin.
Web - Javascript, HTML, CSS, Bootstrap.
Backend - Python, LM Studio, Flask.

Este proyecto ha sido creado por Diego Valdés y Josep Lloret [Infinexum Team].
