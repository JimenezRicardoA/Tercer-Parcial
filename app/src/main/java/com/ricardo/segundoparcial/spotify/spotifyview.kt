package com.ricardo.segundoparcial.spotify

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ricardo.segundoparcial.R
import com.ricardo.segundoparcial.spotyutils.VideoPreloader

@Composable
fun SpotifyView(navController: NavController) {
    Box (modifier = Modifier.fillMaxSize()){
        VideoPreloader(modifier = Modifier
            .fillMaxSize()
            .align (Alignment.Center)
        )

        Image(
            painter = painterResource(id = R.drawable.spotylogo),
            contentDescription = "Descripción de la imagen",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(300.dp)
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-30).dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = {  },
                modifier = Modifier
                    .weight(1f)
                    .size(50.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF37525C),
                    contentColor = Color.White
                )
            ) {
                Text("LOG IN")
            }
            Button(
                onClick = {  },
                modifier = Modifier
                    .weight(1f)
                    .size(50.dp),
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF17AE03),
                    contentColor = Color.White
                )
            ) {
                Text("SIGN UP")
            }
        }
    }
}