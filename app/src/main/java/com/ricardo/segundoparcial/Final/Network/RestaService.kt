package com.ricardo.segundoparcial.Final.Network

import com.ricardo.segundoparcial.Final.Models.Resta
import retrofit2.http.GET

interface RestaServicea {
    @GET("JimenezRicardoA/f0467610d76a7b1f404e81f680fe20eb/raw/dcb6d29788f01c24adff9cd46e4ec3611a383aad/final.json")
    suspend fun getResta() : List <Resta>
}