package com.ricardo.segundoparcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ricardo.segundoparcial.IMC.Imc
import com.ricardo.segundoparcial.IMC.ImcViewModel
import com.ricardo.segundoparcial.examentercerparcial.AguaView
import com.ricardo.segundoparcial.examentercerparcial.AguaViewModel
import com.ricardo.segundoparcial.firstparcial.FirstParcialView
import com.ricardo.segundoparcial.juego.RandomViewModel
import com.ricardo.segundoparcial.juego.random
import com.ricardo.segundoparcial.marcador.Marcador
import com.ricardo.segundoparcial.marcador.SoccerScoreViewModel
import com.ricardo.segundoparcial.secondparcial.SecondParcialView
import com.ricardo.segundoparcial.sumar.SumViewModel
import com.ricardo.segundoparcial.sumar.SumarView
import com.ricardo.segundoparcial.thirdparcial.ThirdParcialView

@Composable
fun MyAppNavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Routes.FirstParcialView, builder =  {

            composable(Routes.FirstParcialView) {
                FirstParcialView(navController)
            }
            composable(Routes.Imc) {
                Imc(viewModel = ImcViewModel(), navController)
            }
            composable(Routes.AguaView) {
                AguaView(viewModel = AguaViewModel(), navController)
            }
            composable(Routes.random) {
                random(viewModel = RandomViewModel(), navController)
            }
            composable(Routes.Marcador) {
                Marcador(viewModel = SoccerScoreViewModel(), navController)
            }
            composable(Routes.Sumar) {
                SumarView(viewModel = SumViewModel(), navController)
            }
            composable(Routes.SecondParcialView) {
                SecondParcialView(navController)
            }
            composable(Routes.ThirdParcialView) {
                ThirdParcialView(navController)
            }



        })
}