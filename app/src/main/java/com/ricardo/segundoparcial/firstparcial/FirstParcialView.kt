package com.ricardo.segundoparcial.firstparcial

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ricardo.segundoparcial.navigation.BottomNavBarView
import com.ricardo.segundoparcial.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstParcialView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Valor", color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFDA00FF),
                )
            )
        },
        content = { innerPadding ->
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {
                Text(
                    text = "First Partial View",
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Button(onClick = {
                    navController.navigate(Routes.Imc)
                }) {
                    Text(text = "Go to Imc",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.AguaView)
                }) {
                    Text(text = "Go to AguaView",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.random)
                }) {
                    Text(text = "Go to random",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.Marcador)
                }) {
                    Text(text = "Go to Marcador",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.Sumar)
                }) {
                    Text(text = "Go to Suma",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.SecondParcialView)
                }) {
                    Text(text = "Go to SecondParcialView",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.ThirdParcialView)
                }) {
                    Text(text = "Go to ThirdParcialView",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.ClickGameView)
                }) {
                    Text(text = "Go to ClickGamme",
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.LottieAnimationView)
                }) {
                    Text(text = "Go to LottieAnimationView",
                        modifier = Modifier
                            .fillMaxWidth())
                }
            }
        },
        bottomBar = {
            BottomNavBarView(navController = navController)
        }
    )
}