package com.ricardo.segundoparcial


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ricardo.segundoparcial.Final.Viewmodel.RestaViewModel
import com.ricardo.segundoparcial.Final.Views.RestaList
import com.ricardo.segundoparcial.Final.myapp.myapp
import com.ricardo.segundoparcial.IMC.Imc
import com.ricardo.segundoparcial.IMC.ImcViewModel
import com.ricardo.segundoparcial.Screens.Gyms.Viewmodel.GymViewModel
import com.ricardo.segundoparcial.Screens.Gyms.Views.GymList
import com.ricardo.segundoparcial.examentercerparcial.AguaView
import com.ricardo.segundoparcial.examentercerparcial.AguaViewModel
import com.ricardo.segundoparcial.juego.RandomViewModel
import com.ricardo.segundoparcial.juego.random
import com.ricardo.segundoparcial.marcador.ExamenSegundoParcial
import com.ricardo.segundoparcial.ui.theme.SegundoParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SegundoParcialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    myapp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SegundoParcialTheme {
        Greeting("Android")
    }
}