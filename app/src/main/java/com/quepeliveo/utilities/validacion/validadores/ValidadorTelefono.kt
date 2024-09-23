package com.quepeliveo.utilities.validacion.validadores

import com.quepeliveo.utilities.validacion.Validacion
import com.quepeliveo.utilities.validacion.Validador

class ValidadorTelefono(
    val error: String = "Teléfono no válido"
) : Validador<String> {
    override fun valida(texto: String): Validacion {
        return object : Validacion {
            override val hayError: Boolean
                get() = !Regex("^[0-9 ]{9,18}$").matches(texto)
            override val mensajeError: String
                get() = error
        }
    }
}