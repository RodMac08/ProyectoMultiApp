package com.example.proyectomultiapp.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoteriaViewModel : ViewModel() {
    private val _lotoNumbers = mutableStateOf(emptyList<Int>())
    val lotoNumber: State<List<Int>> = _lotoNumbers

    fun generateLotoNmubers() {
        _lotoNumbers.value = (1..60).shuffled().take(6).sorted()
    }
}
