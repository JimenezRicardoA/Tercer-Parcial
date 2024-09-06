package com.ricardo.segundoparcial.examenprimerparcial

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


data class HuertoManzanasModel (val ptotal: Int, val v: Int)
class HuertoManzanasViewModel : ViewModel(){

    private val actual = MutableLiveData (0)
    fun getActual() : LiveData<Int> = actual

    private val Total = MutableLiveData (0)
    fun getTotal() : LiveData<Int> = Total

    fun setTotal(newTotal: Int){
        Total.value = newTotal
    }
}