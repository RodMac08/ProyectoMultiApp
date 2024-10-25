package com.example.proyectomultiapp.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectomultiapp.components.PosicionPantalla
import com.example.proyectomultiapp.R

@Composable
fun DogYearView(navController: NavController) {
    PosicionPantalla(
        titulo = "Mis Años Perrunos",
        imagen = painterResource(id = R.drawable.perritos3)
    )
    Button(
        onClick = { navController.navigate("HomeView") },
        modifier = Modifier.padding(top = 700.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
    ) {
        Text("Volver al inicio")
    }
}