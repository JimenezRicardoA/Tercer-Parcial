package com.ricardo.segundoparcial.IMC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.ricardo.segundoparcial.R

@Composable
fun Imc(viewModel: ImcViewModel, navController: NavController) {
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }

    val resultImcByViewModel by viewModel.getResult().observeAsState(0)
    val resultPesoByViewModel by viewModel.getResultPeso().observeAsState(" ")


    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)) {
        Image(painter = painterResource(id = R.drawable.imc), contentDescription = "No jala", modifier = Modifier
            .size(250.dp))
        TextField(value = height, onValueChange = { height = it }, label = { Text(text = "Estatura en metros") })
        TextField(value = weight, onValueChange = { weight = it }, label = { Text(text = "Peso en kilogramos") })
        Button(onClick = { viewModel.calcularImc(ImcModel(height.toDouble(), weight.toDouble())) }) {
            Text(text = "Calcular")
        }
        Text(text = "El peso es de : ${resultImcByViewModel}")
        Text(text = "${resultPesoByViewModel}")
    }
}
