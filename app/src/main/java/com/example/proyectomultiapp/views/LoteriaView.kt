package com.example.proyectomultiapp.views

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.proyectomultiapp.viewmodels.LoteriaViewModel
import com.example.proyectomultiapp.components.LotteryNumbers

@Composable
fun LoteriaView(navController: NavController) {
    val viewModel: LoteriaViewModel = viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        if (viewModel.lotoNumber.value.isEmpty()) {
            Text("Loteria", fontSize = 40.sp)
        } else {
            LotteryNumbers(viewModel.lotoNumber.value)
        }
        Button(onClick = { viewModel.generateLotoNmubers() }) {
            Text(text = "Generar")
        }
        Button(
            onClick = { navController.navigate("HomeView") },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text("Volver al inicio")
        }
    }
}