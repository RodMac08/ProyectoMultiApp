package com.example.proyectomultiapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun DescuentoView(navController: NavController) {
    ContenidoDes()
    Button(
        onClick = { navController.navigate("HomeView") },
        modifier = Modifier.padding(top = 500.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        Text("Volver al inicio")
    }
}
@Composable
fun ContenidoDes() {
    var precioIngresado by remember { mutableStateOf("") }
    var descuentoIngresado by remember { mutableStateOf("") }
    var descuentoFinal by remember { mutableStateOf("") }
    var precioFinal by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            OutlinedTextField(
                value = precioIngresado,
                onValueChange = { precioIngresado = it },
                label = { Text("Precio normal") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            OutlinedTextField(
                value = descuentoIngresado,
                onValueChange = { descuentoIngresado = it },
                label = { Text("Descuento a aplicar") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
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
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
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
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            OutlinedTextField(
                value = descuentoFinal,
                readOnly = true,
                onValueChange = { descuentoFinal = it },
                label = { Text("Descuento") }
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            OutlinedTextField(
                value = precioFinal,
                readOnly = true,
                onValueChange = { precioFinal = it },
                label = { Text("Precio final") }
            )
        }

    }

}