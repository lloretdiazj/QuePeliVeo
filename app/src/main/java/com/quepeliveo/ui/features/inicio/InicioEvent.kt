package com.quepeliveo.ui.features.inicio

sealed interface InicioEvent {

    data class OnPromptChanged(val prompt: String) : InicioEvent
    data class OnClickMas(val numeroPeliculas: String) : InicioEvent
    data class OnClickMenos(val numeroPeliculas: String) : InicioEvent
    data class OnClickPelicula(val posicionPelicula: Int) : InicioEvent
    object OnClickRefresh : InicioEvent
    object OnClickAction : InicioEvent
    object OnDismissDialogoPelicula : InicioEvent
    object OnDismissDialogoInfo : InicioEvent
    object OnClickInfo : InicioEvent
}