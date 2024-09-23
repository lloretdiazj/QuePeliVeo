package com.quepeliveo.ui.features.inicio.uistates

import android.util.Range
import com.quepeliveo.utilities.validacion.Validador
import com.quepeliveo.utilities.validacion.ValidadorCompuesto
import com.quepeliveo.utilities.validacion.validadores.ValidadorLongitudMaximaTexto
import com.quepeliveo.utilities.validacion.validadores.ValidadorLongitudMinimaTexto
import com.quepeliveo.utilities.validacion.validadores.ValidadorNumeroEnteroMaximo
import javax.inject.Inject

class ValidadorConsulta @Inject constructor() : Validador<ConsultaUiState> {
    val validacionPrompt = ValidadorCompuesto<String>()
        .add(ValidadorLongitudMinimaTexto(6,"Escribe mínimo 6 caracteres y máximo 55."))
        .add(ValidadorLongitudMaximaTexto(55,"< 55 caracteres."))
    val validacionNumeroPeliculas = ValidadorCompuesto<String>()
        .add(ValidadorNumeroEnteroMaximo(Range(1, 6),"> 0 | < 6."))



    override fun valida(datos: ConsultaUiState): ValidacionConsultaUiState {
        val validacionPrompt = validacionPrompt.valida(datos.prompt)
        val validacionNumeroPeliculas = validacionNumeroPeliculas.valida(datos.numero)

        return ValidacionConsultaUiState(
            validacionPrompt = validacionPrompt,
            validacionNumeroPeliculas = validacionNumeroPeliculas
        )
    }
}