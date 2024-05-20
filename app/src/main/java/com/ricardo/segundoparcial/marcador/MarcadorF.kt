package com.ricardo.segundoparcial.marcador

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ricardo.segundoparcial.R
import com.ricardo.segundoparcial.ui.theme.SegundoParcialTheme

@Composable
fun Marcador(viewModel: SoccerScoreViewModel){
    val localScoreResult by viewModel.getLocalScore().observeAsState(0)
    val visitScoreResult by viewModel.getVisitScore().observeAsState(0)

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Text("Marcador", modifier = Modifier
            .background(Color.Gray)
            .fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)) {
            Image(painter = painterResource(id = R.drawable.img),
                contentDescription = "Logo del Equipo",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clickable {
                        Log.d("sumarr", "local")
                        viewModel.incrementLocalScore(SoccerScoreLocalModel(localScoreResult))
                    }
            )

            Text(
                text = "${localScoreResult}",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterVertically)
            )

            Text(
                text = "${visitScoreResult}",
                textAlign = TextAlign.Center,
                fontSize = 50.sp,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .align(Alignment.CenterVertically)
            )

            Image(painter = painterResource(id = R.drawable.img_1),
                contentDescription = "Logo del Equipo",
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clickable {
                        Log.d("sumarr", "visitante")
                        viewModel.incrementVisitScore(SoccerScoreVisitModel(visitScoreResult))
                    }
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MarcadorPreview() {
    SegundoParcialTheme {
        Marcador(viewModel = SoccerScoreViewModel())
    }
}