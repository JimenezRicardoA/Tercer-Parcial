package com.ricardo.segundoparcial.marcador

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricardo.segundoparcial.R
import com.ricardo.segundoparcial.ui.theme.SegundoParcialTheme

@Composable
fun ExamenSegundoParcial(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Text("Marcador", modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.img), contentDescription = "Logo del Equipo")
                Text("0", modifier = Modifier
                    .background(Color.Blue),
                    color = Color.White)
            }
            Spacer(modifier = Modifier.width(25.dp))
            Text("VS", modifier = Modifier,
                color = Color.Red)
            Spacer(modifier = Modifier.width(25.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(id = R.drawable.img_1), contentDescription = "Logo del Equipo")
                Text("0", modifier = Modifier
                    .background(Color.Magenta),
                    color = Color.White)
            }
        }
        Button(onClick = { Toast.makeText(context, "Ricardo he terminado mi examen", Toast.LENGTH_SHORT).show() }) {
            Text(text = "Enviar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ExamenSegundoParcialPreview() {
    SegundoParcialTheme {
        ExamenSegundoParcial()
    }
}