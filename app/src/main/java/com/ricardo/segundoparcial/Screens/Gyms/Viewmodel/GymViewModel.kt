package com.ricardo.segundoparcial.Screens.Gyms.Viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ricardo.segundoparcial.Screens.Gyms.Models.Gym
import com.ricardo.segundoparcial.Screens.Gyms.Network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class GymViewModel: ViewModel() {
    private val GymService = RetrofitInstance.api
    val gyms = MutableStateFlow<List<Gym>>(emptyList())
    fun getGyms() {
        viewModelScope.launch {
            try {
                val response = GymService.getGyms()
                Log.d("GymViewModel", "Gyms: $response")
                if (response.isNotEmpty()) {
                    gyms.value = response
                }
            } catch (e: Exception) {
                Log.e(
                    "GymViewModel",
                    e.message ?:"Error al obtener los gimnasios"
                )
            }
        }
    }
}