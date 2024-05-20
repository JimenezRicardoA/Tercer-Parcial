package com.ricardo.segundoparcial.sumar

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricardo.segundoparcial.ui.theme.SegundoParcialTheme

@Composable
fun SumarView(viewModel: SumViewModel) {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var numero3 by remember { mutableStateOf("") }
    val resultbyViewModel by viewModel.getResult().observeAsState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            label = { Text("Número 1") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            label = { Text("Número 2") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = numero3,
            onValueChange = { numero3 = it },
            label = { Text("Número 1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )

        Button(
            onClick = {
                viewModel.sumar(
                    Suma(
                        numero1.toInt(),
                        numero2.toInt(),
                        numero3.toInt()
                    )
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Sumar")
        }
        Text(text = "El reultado es: ${resultbyViewModel}")
    }
}

@Preview(showBackground = true)
@Composable
fun sumarviewPreview() {
    SegundoParcialTheme {
        SumarView(viewModel = SumViewModel())
    }
}