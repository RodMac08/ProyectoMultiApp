package com.example.proyectomultiapp.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectomultiapp.R

@Composable
fun PosicionPantalla(titulo: String, imagen: Painter, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(
        modifier = modifier.padding(16.dp).fillMaxSize()
    ) {
        var edad by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }
        Image(
            painter = imagen,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.Center
        )
        Text(
            text = titulo,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Mi edad humana") }
        )
        ElevatedButton(
            onClick = {
                try {
                    val res = edad.toInt() * 7
                    resultado = res.toString()
                } catch (e: NumberFormatException) {
                    Toast.makeText(context, "Por favor ingrese un número válido", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text("Calcular")
        }
        OutlinedTextField(
            value = resultado,
            readOnly = true,
            onValueChange = { resultado = it },
            label = { Text("Edad Perruna") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            onClick = {
                edad = ""
                resultado = ""
            }
        ) {
            Text("Borrar")
        }

    }
}