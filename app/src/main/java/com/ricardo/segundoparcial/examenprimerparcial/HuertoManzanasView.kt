package com.ricardo.segundoparcial.examenprimerparcial

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext

@SuppressLint("StringFormatMatches")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HuertoManzanasView(viewModel: HuertoManzanasViewModel, navController: NavController){
    var ptotal by remember { mutableStateOf("") }
    var background by remember { mutableStateOf(Color.White) }
    var linea by remember { mutableStateOf(Color.Black) }

    val ProduccionActual by viewModel.getcantidadActual().observeAsState(0)
    val porcentaje by viewModel.getPorcentaje().observeAsState(0.0)
    val unidadesactuales = viewModel.unidadesactuales()
    val context = LocalContext.current

    LaunchedEffect(porcentaje) {
        if (porcentaje >= 70) {
            background = Color.Red
            linea = Color.White
        } else {
            background = Color.White
            linea = Color.Black
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ){
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
                .offset(y = (45).dp)
                .size(300.dp)
        )

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = (80).dp)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text (stringResource(id = R.string.totalproduction),
                    color = Color.Black,
                    style = TextStyle(fontSize = 17.sp),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (30).dp)
                )

                Spacer(modifier = Modifier.height(50.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .offset(70.dp)
                ){
                    BasicTextField(
                        value = ptotal,
                        onValueChange = {
                            ptotal = it
                                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true,
                        textStyle = TextStyle(fontSize = 25.sp, color = Color.Black),
                        modifier = Modifier
                            .offset(5.dp)
                            .padding(start = 0.dp)
                            .border(
                                width = 1.dp,
                                color = background,
                                shape = RectangleShape
                            )
                            .fillMaxWidth()
                    )

                    if (ptotal.isEmpty()) {
                        Text(
                            text = "0",
                            style = TextStyle(fontSize = 25.sp, color = Color.Gray),
                            modifier = Modifier
                                .offset(5.dp)
                                .padding(start = 0.dp)
                                .align(Alignment.CenterStart)
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(1.dp)
                            .background(linea)
                            .align(Alignment.BottomStart)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.manzana),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (25).dp)
                        .size(50.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    context.getString(R.string.total_units, ptotal.toInt() * 80),
                                    Toast.LENGTH_LONG
                                )
                                .show()
                        }
                )

            }

            Spacer(modifier = Modifier.height(10.dp))

            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text (stringResource(id = R.string.currentproduction),
                    color = Color.Black,
                    style = TextStyle(fontSize = 17.sp),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (30).dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .offset(63.dp)
                ){
                    Text ("${ProduccionActual}",
                        color = Color.Black,
                        style = TextStyle(fontSize = 25.sp),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .offset(x = (-67).dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .height(1.dp)
                            .background(linea)
                            .align(Alignment.BottomStart)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.manzana),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (22).dp)
                        .size(50.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    context.getString(R.string.total_units, unidadesactuales),
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                )

            }

            Spacer(modifier = Modifier.height(35.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-10.dp)),
                contentAlignment = Alignment.Center
            ){
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    Button(onClick = { viewModel.incremento(5) },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(80.dp, 80.dp)
                            .padding(0.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF55E4FB),
                            contentColor = Color.White
                        )) {
                        Text("+5", fontSize = 15.sp)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { viewModel.incremento(15)},
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(80.dp, 80.dp)
                            .padding(0.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF55E4FB),
                            contentColor = Color.White
                        )) {
                        Text("+15", fontSize = 15.sp)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { viewModel.incremento(30) },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(80.dp, 80.dp)
                            .padding(0.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF55E4FB),
                            contentColor = Color.White
                        )) {
                        Text("+30", fontSize = 15.sp)
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { viewModel.incremento(50) },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .size(80.dp, 80.dp)
                            .padding(0.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF55E4FB),
                            contentColor = Color.White
                        )) {
                        Text("+50", fontSize = 15.sp)
                    }
                }
            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (20.dp)),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text (stringResource(id = R.string.percentege),
                    color = Color.Black,
                    style = TextStyle(fontSize = 17.sp),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (30).dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .offset(63.dp)
                ){
                    Text ("${porcentaje}",
                        color = Color.Black,
                        style = TextStyle(fontSize = 25.sp),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .offset(x = (-67).dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(1.dp)
                            .background(Color.Black)
                            .align(Alignment.BottomStart)
                    )
                }

            }

            Button(onClick = { viewModel.porcentajes(ptotal.toInt())},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .offset(y = (60.dp)),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF55E4FB),
                    contentColor = Color.White
                )
                ){
                Text(stringResource(id = R.string.calculate))
            }

        }
    }
}