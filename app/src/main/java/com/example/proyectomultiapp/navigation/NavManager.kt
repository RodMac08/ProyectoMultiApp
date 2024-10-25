package com.example.proyectomultiapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectomultiapp.views.*

@Composable
fun NavManager() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeView") {
        composable("HomeView") { HomeView(navController) }
        composable("DogYearView") { DogYearView(navController) }
        composable("DescuentoView") { DescuentoView(navController) }
        composable("LoteriaView") { LoteriaView(navController) }
    }
}
