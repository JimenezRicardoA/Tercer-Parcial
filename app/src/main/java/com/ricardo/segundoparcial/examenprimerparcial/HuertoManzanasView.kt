package com.ricardo.segundoparcial.examenprimerparcial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ricardo.segundoparcial.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HuertoManzanasView(viewModel: HuertoManzanasViewModel, navController: NavController){
    val ProduccionTotal by viewModel.getTotal().observeAsState(0)
    val ProduccionActual by viewModel.getActual().observeAsState(0)

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
                .offset(y = (-20).dp)
        ){
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text ("Produccion Total",
                    color = Color.Black,
                    style = TextStyle(fontSize = 17.sp),
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .offset(x = (30).dp)
                )
                Text ("${ProduccionTotal}",
                    color = Color.Black,
                    style = TextStyle(fontSize = 25.sp),
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .offset(x = (103).dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.manzana),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (170).dp)
                        .size(50.dp)
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text ("Produccion Actual",
                    color = Color.Black,
                    style = TextStyle(fontSize = 17.sp),
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .offset(x = (30).dp)
                )
                Text ("${ProduccionActual}",
                    color = Color.Black,
                    style = TextStyle(fontSize = 25.sp),
                    modifier = Modifier.align(Alignment.CenterVertically)
                        .offset(x = (93).dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.manzana),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (160).dp)
                        .size(50.dp)
                )

            }

        }
    }
}