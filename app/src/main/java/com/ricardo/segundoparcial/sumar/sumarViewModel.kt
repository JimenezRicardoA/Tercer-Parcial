package com.ricardo.segundoparcial.sumar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Define el modelo de datos para tu app
data class Suma(val numero1: Int, val numero2: Int, val numero3: Int)

// Crea la clase ViewModel para manejar la lógica de negocio de tu app
class SumViewModel : ViewModel() {
    private val resultado = MutableLiveData(0)
    fun getResult(): LiveData<Int> = resultado

    fun sumar(sum: Suma) {
        print("intento de sumar")
        Log.i("Number1", sum.numero1.toString())
        Log.i("Number1", sum.numero2.toString())
        Log.i("Number1", sum.numero3.toString())
        Log.e("error", "Hubo un error")
        resultado.postValue(sum.numero1 + sum.numero2 + sum.numero3)
    }
}
