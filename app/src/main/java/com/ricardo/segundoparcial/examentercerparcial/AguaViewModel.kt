package com.ricardo.segundoparcial.examentercerparcial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class CantTotal(val total: Double = 0.0)

class AguaViewModel : ViewModel() {
    val resultado = MutableLiveData (0.0)
    fun getResultado(): LiveData<Double> = resultado


    fun incrementar (incremento: CantTotal){
        val total = resultado.value?.plus(incremento.total)
        resultado.postValue(total)
    }


    fun reestablecer(){
        resultado.postValue(0.0)
    }
}
