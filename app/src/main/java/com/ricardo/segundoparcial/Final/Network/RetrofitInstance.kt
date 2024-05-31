package com.ricardo.segundoparcial.Final.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance2 {
    private
    const val BASE_URL = "https://gist.githubusercontent.com/"
    val api: RestaServicea by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestaServicea::class.java)
    }
}