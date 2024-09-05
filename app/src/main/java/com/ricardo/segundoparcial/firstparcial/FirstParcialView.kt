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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ricardo.segundoparcial.R
import com.ricardo.segundoparcial.navigation.BottomNavBarView
import com.ricardo.segundoparcial.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstParcialView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id = R.string.tFirstParcial), color = Color.White) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF55E4FB),
                )
            )
        },
        content = { innerPadding ->
            Column (modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
            ) {
                Text(
                    text = (stringResource(id = R.string.bFirstParcialView)),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Button(onClick = {
                    navController.navigate(Routes.Imc)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bIMC)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.AguaView)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bAguaView)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.random)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bRandom)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.Marcador)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bMarcador)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.Sumar)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bSuma)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.SecondParcialView)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bSecondPartial)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.ThirdParcialView)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bthirdPartial)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.ClickGameView)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bClickGame)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.LottieAnimationView)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bLottieAnimation)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.SpotifyView)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bspotify)),
                        modifier = Modifier
                            .fillMaxWidth())
                }
                Button(onClick = {
                    navController.navigate(Routes.HuertoManzanasView)
                }) {
                    Text(
                        text = (stringResource(id = R.string.bexamPrimPar)),
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