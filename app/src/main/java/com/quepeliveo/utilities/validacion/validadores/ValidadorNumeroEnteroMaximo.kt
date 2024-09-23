package com.quepeliveo.utilities.validacion.validadores

import android.util.Range
import com.quepeliveo.utilities.validacion.Validacion
import com.quepeliveo.utilities.validacion.Validador

class ValidadorNumeroEnteroMaximo(
    val rango: Range<Int> = Range(0, Int.MAX_VALUE),
    val error: String = "Se espera un valor entre 0 y 6."
) : Validador<String> {
    override fun valida(texto: String): Validacion {
        return object : Validacion {
            override val hayError: Boolean
                get() = !texto.matches(Regex("^[+-]?[0-9]+$"))
                        ||
                        !rango.contains(texto.toInt())
            override val mensajeError: String
                get() = error
        }
    }
}