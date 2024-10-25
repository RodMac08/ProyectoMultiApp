package com.example.proyectomultiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.proyectomultiapp.navigation.NavManager
//import com.example.multiapp.ui.theme.MultiAppProjectTheme
import com.example.proyectomultiapp.ui.theme.ProyectoMultiAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoMultiAppTheme {

                Surface {
                    NavManager()
                }
            }
        }
    }
}
