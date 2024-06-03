package com.ricardo.segundoparcial.Final.Views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.ricardo.segundoparcial.Final.Viewmodel.RestaViewModel
import com.ricardo.segundoparcial.R
import java.net.URLDecoder
import java.nio.charset.StandardCharsets


@Composable
fun RestaView(resta: String, viewModel: RestaViewModel, navController: NavController){
    val restaurantes by viewModel.restaurantes.collectAsState()
    val decodedName = URLDecoder.decode(resta, StandardCharsets.UTF_8.toString())
    val context = LocalContext.current
    val LinkBlue = Color(0xFF0000EE)

    LazyColumn{
        items(restaurantes.filter { it.name == decodedName}) {
            restaurantes ->
            Row (modifier = Modifier){
                Row (verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = {
                        navController.popBackStack()
                    })){
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back Icon",
                        tint = LinkBlue,
                        modifier = Modifier.size(18.dp)
                    )
                    Text(
                        text = "Back",
                        color = LinkBlue,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            },
                        textAlign = TextAlign.Start
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)  // This ensures the Box takes all available space
                ){
                    Column (
                        modifier = Modifier.align(Alignment.Center)
                    ) {
                        Text(
                            text = restaurantes.name,
                            fontWeight = FontWeight.Bold,
                            fontSize = 21.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            AsyncImage(
                model = restaurantes.imgName,
                contentDescription = "Imagen del restaurante",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
            )

            val LatLng = LatLng(restaurantes.latitude.toDouble(), restaurantes.longitude.toDouble())
            val cameraPositionState = rememberCameraPositionState{
                position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(LatLng, 15f)
            }
            GoogleMap (
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f),
                cameraPositionState = cameraPositionState,
            ){
                Marker(
                    state = com.google.maps.android.compose.MarkerState(position = LatLng),
                    title = restaurantes.name,
                    snippet = "Restaurant Location"
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Row (
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:${restaurantes.phone}")
                        context.startActivity(intent)
                    },
                    verticalAlignment = Alignment.CenterVertically
                )  {
                    Icon(
                        painter = painterResource(id = R.drawable.call),
                        contentDescription = "Phone Icon",
                        tint = LinkBlue,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Llamar",
                        color = LinkBlue,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.Underline)
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ){
                Row (
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(restaurantes.webSite)
                        context.startActivity(intent)
                    },
                    verticalAlignment = Alignment.CenterVertically
                )  {
                    Icon(
                        painter = painterResource(id = R.drawable.computer),
                        contentDescription = "Computer Icon",
                        tint = LinkBlue,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Sitio Web",
                        color = LinkBlue,
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.Underline)
                }
            }
        }
    }

    DisposableEffect(Unit) {
        viewModel.getResta()
        onDispose { }
    }
}

