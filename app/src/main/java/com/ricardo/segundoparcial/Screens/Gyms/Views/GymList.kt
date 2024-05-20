package com.ricardo.segundoparcial.Screens.Gyms.Views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import com.ricardo.segundoparcial.Screens.Gyms.Viewmodel.GymViewModel

@Composable
fun GymList(viewModel: GymViewModel) {
    val gyms by viewModel.gyms.collectAsState()
    LazyColumn {
        items(gyms) {
                gym ->
            Text(text = gym.name)
            AsyncImage(
                model = gym.imageURL,
                contentDescription = "Imagen del gimnasio",
                contentScale = ContentScale.Crop
            )
            Text(text = gym.latitude)
            Text(text = gym.longitude)
        }
    }
    DisposableEffect(Unit) {
        viewModel.getGyms()
        onDispose {}
    }
}