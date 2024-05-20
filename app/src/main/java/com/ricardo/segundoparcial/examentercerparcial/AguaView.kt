package com.ricardo.segundoparcial.examentercerparcial

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricardo.segundoparcial.R
import com.ricardo.segundoparcial.ui.theme.SegundoParcialTheme


@Composable
fun AguaView(viewModel: AguaViewModel) {

    val aguatotal by viewModel.getResultado().observeAsState(0.0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        Text("Cuanta agua tomo", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth(),
            textAlign = TextAlign.Center)

        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Image(painter = painterResource(id = R.drawable.litro),
                contentDescription = "Un litro de agua",
                modifier = Modifier
                    .height(175.dp)
                    .width(200.dp)
                    .clickable {
                        Log.d("Litro", "Agua Total")
                        viewModel.litro(CantTotal (aguatotal))
                    })
            
            Text("Un Litro")
        }

        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Image(painter = painterResource(id = R.drawable.ml500),
                contentDescription = "500 ml de agua",
                modifier = Modifier
                    .height(175.dp)
                    .width(200.dp)
                    .clickable {
                        Log.d("Medio litro", "Agua Total")
                        viewModel.medio(CantTotal (aguatotal))
                    })

            Text("500 ml")
        }

        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Image(painter = painterResource(id = R.drawable.ml250),
                contentDescription = "250 ml de agua",
                modifier = Modifier
                    .height(175.dp)
                    .width(200.dp)
                    .clickable {
                        Log.d("Cuarto litro", "Agua Total")
                        viewModel.cuarto(CantTotal (aguatotal))
                    })

            Text("250 ml")
        }

        Text(text = "Total de agua consumida: ${aguatotal} ")

        Button(onClick = {viewModel.reestablecer()}) {
            Text(text = "Restablecer")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AguaPreview() {
    SegundoParcialTheme {
        AguaView(viewModel= AguaViewModel())
    }
}