package com.ricardo.segundoparcial.clickgame

import android.content.Context
import android.media.MediaPlayer
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import com.ricardo.segundoparcial.R
import kotlinx.coroutines.delay

@Composable
fun ClickGameView(viewModel: clickgameViewModel, navController: NavController) {
    val context = LocalContext.current

    var buttonSize by remember { mutableStateOf(100.dp) }
    var mediaPlayer by remember {mutableStateOf<MediaPlayer?>(null)}

    //Animacion de rebote
    val animatedButtonSize by animateDpAsState(
        targetValue = buttonSize,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    //Reproduccion y detecion del sonido
    LaunchedEffect(viewModel.counter){
        if (viewModel.counter == 1){
            mediaPlayer?.release() //libera la memoria del MediaPlayer
            mediaPlayer = MediaPlayer.create(context, R.raw.game).apply{
                isLooping = true
                start()
            }
        }
    }

    LaunchedEffect(viewModel.timeLeft){
        if (viewModel.timeLeft == 0){
            mediaPlayer?.stop()
            mediaPlayer?.release()
            mediaPlayer = null
        }
    }

    Box (modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Time Left ${viewModel.timeLeft} secs", modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        )

        Text (
            "Best Score", modifier = Modifier
                .align(Alignment.TopStart)
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text (text = viewModel.counter.toString())
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    viewModel.onButtonClick()
                    buttonSize = 120.dp // Aumentar temporalmente el tamaño para simular el rebote
                },
                enabled = viewModel.isButtonEnabled,
                modifier = Modifier.size(animatedButtonSize)
            ) {
                Text(text = "Aumentar")
            }
        }
        LaunchedEffect(buttonSize){
            if(buttonSize > 100.dp){
                delay(300)
                buttonSize = 100.dp
            }
        }
    }
}
