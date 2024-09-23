# QuePeliVeo - Android - Recomendador de películas

## Descripción.

QuePeliVeo es una aplicación con utilidad para recomendar películas a partir de una descripción y el número de películas que queremos recibir. Además si te ha gustado la recomendación puedes compartirla con alguien para verla, también tiene sinopsis, año, géneros, poster y enlace de IMDB.

## Funcionamiento de la App.

El usuario inicia la App, y se encuentra con la pantalla inicio el cual consta de una interfaz con un TextField y un contador con botones para incrementar dicho contador. Se insertará una descripción de no más de 6 caracteres y 55 de máximo, podremos seleccionar la cantidad de películas que queremos obtener utilizando los botones de flecha arriba - abajo, el cual será un máximo de 6. Tras escribir la descripción y seleccionar el número de películas el botón estará habilitado si hemos cumplido con las validaciones pertinentes y procederá a cargar la lista de películas recomendada.

Al mostrar la lista se colapsará la imagen pasando a las barra superior, permitiéndonos tener más visión de pantalla en la lista.

Cada película consta ed una tarjeta, cada uno de ellas nos mostrará título, año, puntuación, géneros y botón de enlace a IMDB. Toda esta información se extrae de TheMovieDataBase [TMDB].
Al pulsar el botón de IMDB intentará abrir la aplicación IMDB oficial si se encuentra instalada en el sistema, sino abrirá el navegador con la página web oficial de IMDB.

Podemos pulsar sobre cada tarjeta, de forma que al pulsar sobre una nos abrirá un diálogo con titulo, año, puntuación, géneros, sinopsis y botón de compartir. Este botón permite enviar un mensaje por la aplicación que mejor considere el usuario.

QuePeliVeo ha sido desarrollada usando ViewModel y patron Modelo Vista - Vista Modelo (MVVM). También se hace uso de la librería Retrofit para hacer las conexiones HTTP.

## Tecnología.

Esta desarrollada con Kotlin en Jetpack Compose, usando Android Studio, en él tenemos una interfaz y lógica de negocio capacitada para conectarse al servidor donde se encuentra nuestra aplicación Backend. Este está desarrollado en Python usando Flask, conectándonos a una Inteligencia Artificial alojada localmente, de forma que con la descripción obtenida por el usuario le consulta y esta devuelve un resultado de películas, una vez obtenidos los títulos la aplicación Backend es el encargado de procesar y obtener la información de cada película para así ser devuelta a la App y esta mostrarlos.

## Capturas.

<!-- ![Alt text](./img/1.jpg?raw=true "Captura 1")
![Alt text](./img/2.jpg?raw=true "Captura 2")
![Alt text](./img/3.jpg?raw=true "Captura 3") -->
| ![Alt text](./img/1.jpg?raw=true "Captura 1") | ![Alt text](./img/2.jpg?raw=true "Captura 2") | ![Alt text](./img/3.jpg?raw=true "Captura 3") |
|:---------------------------------------------:|:---------------------------------------------:|:---------------------------------------------:|


## Desarrollo.

- App - Jetpack Compose, Kotlin.
- Web - Javascript, HTML, CSS, Bootstrap.
- Backend - Python, LM Studio, Flask.

Este proyecto ha sido creado por Diego Valdés y Josep Lloret [-Infinexum Team-].


