package com.ricardo.segundoparcial.examenprimerparcial

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


data class porcentajes (val pactual: Int, val ptotal: Int)
data class ManzanasHuertoModel (val pactual: Int)
class HuertoManzanasViewModel : ViewModel(){

    private val actual = MutableLiveData (0)
    fun getActual() : LiveData<Int> = actual

    private val Total = MutableLiveData (0)
    fun getTotal() : LiveData<Int> = Total

    private val background = MutableLiveData(Color.White)
    fun getBackgroundColor(): LiveData<Color> = background

    private val porcentaje = MutableLiveData(0.0)
    fun getPorcentaje(): LiveData<Double> = porcentaje

    fun incremento (incremento: ManzanasHuertoModel){
        val nactual = actual.value?.plus(incremento.pactual)
        actual.postValue(nactual)
    }

    fun porcentajes(calc: porcentajes){
        val resultado = (calc.pactual * 100.0) / calc.ptotal
        porcentaje.postValue(resultado)
        if (resultado >= 70){
            background.postValue(Color.Red)
        }
    }
}