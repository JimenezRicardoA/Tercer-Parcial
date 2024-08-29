package com.ricardo.segundoparcial.lottie

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import com.ricardo.segundoparcial.utils.AnimatedPreloader
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun LottieAnimationView(navController: NavController) {
    Box{
        AnimatedPreloader(modifier = Modifier.size(200.dp).align(Alignment.Center))
    }
}
