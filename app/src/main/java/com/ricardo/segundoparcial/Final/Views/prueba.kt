package com.ricardo.segundoparcial.Final.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.navigation.NavController
import com.ricardo.segundoparcial.Final.Viewmodel.RestaViewModel
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun prueba(resta: String, viewModel: RestaViewModel, navController: NavController){

    Column {
        Text(text = "ejele")

        Row {
            Button(onClick = {
                navController.popBackStack() }) {
                Text("Atras")
            }
        }
    }
}