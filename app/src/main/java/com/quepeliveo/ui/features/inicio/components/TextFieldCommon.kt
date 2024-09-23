package com.quepeliveo.ui.features.inicio.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import com.quepeliveo.utilities.validacion.Validacion


@Composable
fun OutlinedTextFieldConError(
    modifier: Modifier = Modifier,
    textoState: String?,
    enabled: Boolean = true,
    textoPista: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    readOnly: Boolean = false,
    validacionState: Validacion,
    textStyle: TextStyle = TextStyle(color = Color.Black),
    onValueChange: (String) -> Unit,


    ) {
    OutlinedTextField(
        textStyle = textStyle,
        modifier = modifier,
        value = textoState.toString(),
        enabled = enabled,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
            Text(
                text = textoPista,
                style = TextStyle(
                    color = Color.Gray
                )
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        readOnly = readOnly,
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!, color = Color(0xffff4444))
            }
        },
        isError = validacionState.hayError,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color(0xff555555),
            errorBorderColor = Color(0xffff4444)
        )

    )
}


@Composable
fun OutlinedTextFieldConErrorNumerico(
    modifier: Modifier = Modifier,
    textoState: String?,
    enabled: Boolean = true,
    textoPista: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
    validacionState: Validacion,
    textStyle: TextStyle = TextStyle(color = Color.Black)
) {
    OutlinedTextField(
        modifier = modifier,
        textStyle = textStyle,
        value = textoState.toString(),
        enabled = enabled,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
            Text(
                text = textoPista,
                style = TextStyle(color = Color.Gray)
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        supportingText = {
            if (validacionState.hayError) {
                Text(text = validacionState.mensajeError!!, color = Color(0xffff4444))
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color(0xff555555),
            errorBorderColor = Color(0xffff4444)
        ),
        isError = validacionState.hayError

    )
}
