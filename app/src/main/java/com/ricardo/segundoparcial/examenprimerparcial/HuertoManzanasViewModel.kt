package com.ricardo.segundoparcial.examenprimerparcial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HuertoManzanasViewModel : ViewModel(){
    val actual = MutableLiveData (0)
    val Total = MutableLiveData (0)

    fun getActual() : LiveData<Int> = actual
    fun getTotal() : LiveData<Int> = Total
}