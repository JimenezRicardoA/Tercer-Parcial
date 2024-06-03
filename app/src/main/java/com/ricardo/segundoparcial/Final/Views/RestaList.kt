package com.ricardo.segundoparcial.Final.Views

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.ricardo.segundoparcial.Final.Viewmodel.RestaViewModel
import com.ricardo.segundoparcial.ui.theme.SegundoParcialTheme
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import androidx.compose.material3.Icon
import androidx.compose.ui.res.painterResource
import com.ricardo.segundoparcial.R


@Composable
fun RestaList(viewModel: RestaViewModel, navController: NavHostController){
    val restaurantes by viewModel.restaurantes.collectAsState()
    val LinkBlue = Color(0xFF0000EE)

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
                    resta ->
                Column(
                    modifier = Modifier
                        .clickable {
                            val encodedName =
                                URLEncoder.encode(resta.name, StandardCharsets.UTF_8.toString())
                            navController.navigate("RestaView/$encodedName")
                        }
                        .fillMaxWidth()
                ) {
                    Box {
                        AsyncImage(
                            model = resta.imgName,
                            contentDescription = "Imagen del restaurante",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(16f / 9f)
                        )
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorito",
                            tint = Color(0xFFDBE6E7),
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(8.dp)  // Agrega un poco de padding para no pegar el ícono al borde
                        )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = resta.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp)

                        Box(
                            modifier = Modifier
                                .background(Color(0xFFE4E6EF))
                                .padding(4.dp)
                        ){
                            Text(text = "4.5",
                                color = Color(0xFF000000),
                                fontSize = 16.sp)
                        }
                    }

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween){
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Icon(
                                painter = painterResource(id = R.drawable.license),
                                contentDescription = "Icon Description",
                                tint = Color(0xFFD3A13C),
                                modifier = Modifier.size(24.dp)
                            )
                            Text(
                                text = "MX ${resta.fee} Delivery ${resta.delivery}",
                                color = Color.Black
                            )
                        }
                        Text(text = resta.schedule,
                            color = Color.Black)
                    }
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

@Preview(showBackground = true)
@Composable
fun RestaListPreview() {
    SegundoParcialTheme {
        RestaList(viewModel = RestaViewModel(), navController = rememberNavController())
    }
}