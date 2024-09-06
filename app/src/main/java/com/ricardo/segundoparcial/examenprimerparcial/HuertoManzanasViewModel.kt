package com.ricardo.segundoparcial.examenprimerparcial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class ManzanasHuertoModel (val monto: Int, val ptotal: Int)
class HuertoManzanasViewModel : ViewModel(){

    private val cantidadActual  = MutableLiveData(0)
    fun getcantidadActual(): LiveData<Int> = cantidadActual

    private val porcentaje = MutableLiveData(0.0)
    fun getPorcentaje(): LiveData<Double> = porcentaje

    private val unis = MutableLiveData(0)

    fun incremento (monto : Int){
        cantidadActual.postValue((cantidadActual.value?:0) + monto)
    }

    fun porcentajes(ptotal: Int){
        porcentaje.postValue(((cantidadActual.value?:0) * 100) / ptotal.toDouble())
    }

    fun unidadesactuales(): String{
        val uni = (cantidadActual.value?:0) * 80
        return uni.toString()
    }
}