package com.ricardo.segundoparcial.Final.myapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ricardo.segundoparcial.Final.Viewmodel.RestaViewModel
import com.ricardo.segundoparcial.Final.Views.RestaList
import com.ricardo.segundoparcial.Final.Views.RestaView
import com.ricardo.segundoparcial.Final.Views.prueba

@Composable
fun myapp(){
    val navController = rememberNavController()
    val rsvm : RestaViewModel = viewModel()
    NavHost(navController = navController, startDestination = "RestaList"){
        composable("RestaList"){
            RestaList(viewModel = rsvm, navController = navController)
        }
        composable("RestaView/{resta}"){ backStackEntry ->
            val resta = backStackEntry.arguments?.getString("resta")
            resta?.let {
                prueba(resta = it, viewModel = RestaViewModel(), navController = navController)
            }
        }
    }
}