package com.quepeliveo.ui.features.inicio.uistates


import com.quepeliveo.utilities.validacion.Validacion
import com.quepeliveo.utilities.validacion.ValidacionCompuesta

data class ValidacionConsultaUiState(
    val validacionPrompt: Validacion = object : Validacion {},
    val validacionNumeroPeliculas: Validacion = object : Validacion {},

    ) : Validacion {
    private lateinit var validacionCompuesta: ValidacionCompuesta
    private fun componerValidacion(): ValidacionCompuesta {
        validacionCompuesta = ValidacionCompuesta()
            .add(validacionNumeroPeliculas)
            .add(validacionPrompt)

        return validacionCompuesta
    }

    override val hayError: Boolean
        get() = componerValidacion().hayError
    override val mensajeError: String?
        get() = validacionCompuesta.mensajeError
}
