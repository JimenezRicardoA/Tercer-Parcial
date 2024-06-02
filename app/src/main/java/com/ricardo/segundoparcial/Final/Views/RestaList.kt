package com.ricardo.segundoparcial.Final.Views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.ricardo.segundoparcial.Final.Models.Resta
import com.ricardo.segundoparcial.Final.Viewmodel.RestaViewModel
import com.ricardo.segundoparcial.Final.Viewmodel.RsViewModel
import com.ricardo.segundoparcial.ui.theme.SegundoParcialTheme
import kotlinx.serialization.json.Json



@Composable
fun RestaList(viewModel: RestaViewModel, navController: NavHostController){
    val restaurantes by viewModel.restaurantes.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Lista de Restaurantes",
            fontWeight = FontWeight.Bold,
            fontSize = 21.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )
        LazyColumn {
            items(restaurantes) {
                restaurantes ->
                Column(
                    modifier = Modifier
                        .clickable {
                            navController.navigate("myapp/$restaurantes")
                        }
                        .fillMaxWidth()
                ) {
                    AsyncImage(
                        model = restaurantes.imgName,
                        contentDescription = "Imagen del restaurante",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(16f / 9f)
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = restaurantes.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp)

                        Box(
                            modifier = Modifier
                                .background(Color(0xFFE4E6EF) )
                                .padding(4.dp)
                        ){
                            Text(text = "4.5",
                                color = Color(0xFF000000),
                                fontSize = 16.sp)
                        }
                    }
                    Text(
                        text = "MX $0 Delivery Free 35-45 min",
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
        DisposableEffect(Unit) {
            viewModel.getResta()
            onDispose { }
        }
    }
}

@Composable
fun myapp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "restas"){
        composable("restas"){
            RestaList(viewModel = RestaViewModel(), navController)
        }
        composable("resta/{rest}", arguments = listOf(navArgument("rest") { type = NavType.StringType})){ backStackEntry ->
            val json = backStackEntry.arguments?.getString("rest")
            val rs = Json.decodeFromString<Resta>(json!!)
            RestaView(rs, navController, viewModel = RsViewModel() )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RestaListPreview() {
    SegundoParcialTheme {
        RestaList(viewModel = RestaViewModel(), navController = rememberNavController())
    }
}