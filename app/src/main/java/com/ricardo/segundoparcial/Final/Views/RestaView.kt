package com.ricardo.segundoparcial.Final.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.ricardo.segundoparcial.Final.Viewmodel.RestaViewModel
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button

@Composable
fun RestaView(resta: String, viewModel: RestaViewModel, navController: NavController){
    val restaurantes by viewModel.restaurantes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){

        LazyColumn{
            items(restaurantes) {
                restaurantes ->
                Row {
                    Button(onClick = {
                        navController.navigate("myapp/$restaurantes") }) {
                        Text("Atras")
                    }
                    Text(
                        text = restaurantes.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 21.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        textAlign = TextAlign.Center
                    )
                }
                AsyncImage(
                    model = restaurantes.imgName,
                    contentDescription = "Imagen del restaurante",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                )
            }
        }

        DisposableEffect(Unit) {
            viewModel.getResta()
            onDispose { }
        }
    }
}

