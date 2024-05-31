package com.ricardo.segundoparcial.Final.Network

import com.ricardo.segundoparcial.Final.Models.Resta
import retrofit2.http.GET

interface RestaServicea {
    @GET("JimenezRicardoA/f0467610d76a7b1f404e81f680fe20eb/raw/c25d72c77ce6c88fc69fa0e467d87d741a91a31d/final.json")
    suspend fun getResta() : List <Resta>
}