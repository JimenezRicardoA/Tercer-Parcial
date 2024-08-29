package com.ricardo.segundoparcial.clickgame

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class clickgameViewModel : ViewModel() {

    // Variable que va a mostrar el puntaje actual y por default inicia en 0
    var counter by mutableStateOf(0)
        private set

    // Variable que va a mostrar el tiempo restante y por default inicia en 10 segundos
    var timeLeft by mutableStateOf(10)
        private set

    //Variable que va a habilitar el boton.
    var isButtonEnabled by mutableStateOf(true)
        private set

    //Variable que va a manejar el tiempo de la tarea
    private var timerJob : Job? = null

    //Funcion que se va a ejecutar al presionar el boton
    fun onButtonClick(){
        counter++
        if(timerJob == null || timeLeft == 0){
            startTimer()
        }
    }

    private fun startTimer(){
        timerJob?.cancel()
        isButtonEnabled = true
        timerJob = viewModelScope.launch{
            while (timeLeft > 0){
                delay(1000L)
                timeLeft--
            }
            isButtonEnabled = false
            timerJob = null
        }
    }
}