package com.ricardo.segundoparcial.firstparcial

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.ricardo.segundoparcial.navigation.Routes

@Composable
fun FirstParcialView(navController: NavController) {
    Column {
        Text("First View")
        Button(onClick = {
            navController.navigate(Routes.Imc)
        }) {
            Text(text = "Go to Imc")
        }
        Button(onClick = {
            navController.navigate(Routes.AguaView)
        }) {
            Text(text = "Go to AguaView")
        }
        Button(onClick = {
            navController.navigate(Routes.random)
        }) {
            Text(text = "Go to random")
        }
        Button(onClick = {
            navController.navigate(Routes.Marcador)
        }) {
            Text(text = "Go to Marcador")
        }
        Button(onClick = {
            navController.navigate(Routes.Sumar)
        }) {
            Text(text = "Go to Suma")
        }
    }
}