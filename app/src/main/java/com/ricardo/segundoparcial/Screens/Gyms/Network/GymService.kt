package com.ricardo.segundoparcial.Screens.Gyms.Network

import com.ricardo.segundoparcial.Screens.Gyms.Models.Gym
import retrofit2.http.GET


interface GymService{
    @GET("JimenezRicardoA/a5303cd8da4cac493507e2129dec2bd3/raw/940ace391a960cf1d3aeb84c1b6f93c9c49a3da6/gyms.txt")
    suspend fun getGyms() : List <Gym>
}