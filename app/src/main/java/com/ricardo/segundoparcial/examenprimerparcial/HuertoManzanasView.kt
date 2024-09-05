package com.ricardo.segundoparcial.examenprimerparcial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ricardo.segundoparcial.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HuertoManzanasView(viewModel: HuertoManzanasViewModel, navController: NavController){
    Box{
        TopAppBar(
            title = { Text(stringResource(id = R.string.tExamenPrimerParcial), color = Color.White) },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF55E4FB),
            ), modifier = Modifier.align(Alignment.TopCenter)
        )

        Image(
            painter = painterResource(id = R.drawable.manzanas),
            contentDescription = "Descripción de la imagen",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (30).dp)
                .size(300.dp)
        )

        Column(
            modifier = Modifier.align(Alignment.Center)
                .offset(y = (-50).dp)
        ){
            Text("Huerto de Manzanas", color = Color.Black)

        }
    }
}