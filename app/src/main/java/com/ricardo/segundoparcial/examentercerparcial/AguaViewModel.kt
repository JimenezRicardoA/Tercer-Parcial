package com.ricardo.segundoparcial.examentercerparcial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class CantTotal(val total: Double = 0.0)

class AguaViewModel : ViewModel() {
    val resultado = MutableLiveData (0.0)
    fun getResultado(): LiveData<Double> = resultado

    fun litro (localModel: CantTotal){
        var incrementlitro = localModel.total + 1
        resultado.postValue(incrementlitro)
    }

    fun medio (medModel: CantTotal){
        val incrementmedio = medModel.total + .500
        resultado.postValue(incrementmedio)
    }

    fun cuarto (cuartModel: CantTotal){
        val incrementcuarto = cuartModel.total + .250
        resultado.postValue(incrementcuarto)
    }

    fun reestablecer(){
        resultado.postValue(0.0)
    }
}
