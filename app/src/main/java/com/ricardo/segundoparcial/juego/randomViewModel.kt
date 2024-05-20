package com.ricardo.segundoparcial.juego

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomViewModel : ViewModel() {
    private val resultGame = MutableLiveData(-1)
    fun getResult(): LiveData<Int> = resultGame

    fun playGame() {
        print("Intenta Jugar")
        resultGame.postValue((0..2).random())
    }
}