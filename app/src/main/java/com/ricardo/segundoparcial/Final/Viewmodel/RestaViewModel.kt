package com.ricardo.segundoparcial.Final.Viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardo.segundoparcial.Final.Models.Resta
import com.ricardo.segundoparcial.Final.Network.RetrofitInstance2
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class RestaViewModel : ViewModel() {
    private val RestaServicea = RetrofitInstance2.api
    val restaurantes = MutableStateFlow<List<Resta>>(emptyList())
    fun getResta() {
        viewModelScope.launch {
            try {
                val response = RestaServicea.getResta()
                Log.d("RestaViewModel", "Restaurantes: $response")
                if (response.isNotEmpty()) {
                    restaurantes.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "RestaViewModel",
                    e.message ?:"Error al obtener los restaurantes"
                )
            }
        }
    }
}