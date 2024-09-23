package com.quepeliveo.ui.features.inicio.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quepeliveo.ui.theme.QuePeliVeoTheme

@Composable
fun ButtonEnlace(
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xffffca2c),
            contentColor = Color.Black,
            disabledContainerColor = Color(0xffffca2c),
            disabledContentColor = Color(0xffffca2c),
        ),
        modifier = Modifier.width(100.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = "IMDb",
            color = Color.Black,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = amazonEmber
        )
    }
}

@Composable
fun ButtonBuscar(
    onClick: () -> Unit,
    estadoBoton: Boolean
) {
    Button(
        enabled = estadoBoton,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color(0xffffca2c),
        ),
        modifier = Modifier.width(200.dp),
        border = BorderStroke(1.dp, Color.Black),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(
            text = "Qué puedo ver!",
            color = Color.Black,
            fontSize = 17.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBoton() {
    QuePeliVeoTheme {
        ButtonEnlace(
            onClick = {}
        )
    }
}