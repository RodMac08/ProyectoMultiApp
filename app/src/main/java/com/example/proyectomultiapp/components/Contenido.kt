package com.example.proyectomultiapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Contenido() {
    var precioIngresado by remember { mutableStateOf("") }
    var descuentoIngresado by remember { mutableStateOf("") }
    var descuentoFinal by remember { mutableStateOf("") }
    var precioFinal by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = precioIngresado,
            onValueChange = { precioIngresado = it },
            label = { Text("Precio normal") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = descuentoIngresado,
            onValueChange = { descuentoIngresado = it },
            label = { Text("Descuento a aplicar") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                val res = precioIngresado.toDouble() * (descuentoIngresado.toDouble() / 100)
                descuentoFinal = res.toString()
                val resta = precioIngresado.toDouble() - descuentoFinal.toDouble()
                precioFinal = resta.toString()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
            )
        ) {
            Text(text = "Calcular", fontSize = 20.sp)
        }
        Button(
            onClick = {
                precioIngresado = ""
                descuentoIngresado = ""
                precioFinal = ""
                descuentoFinal = ""
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(text = "Borrar", fontSize = 20.sp)
        }
        OutlinedTextField(
            value = descuentoFinal,
            readOnly = true,
            onValueChange = { descuentoFinal = it },
            label = { Text("Descuento") }
        )
    }
}