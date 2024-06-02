package com.ricardo.segundoparcial.Final.Views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.ricardo.segundoparcial.Final.Models.Resta
import com.ricardo.segundoparcial.Final.Viewmodel.RsViewModel

@Composable
fun RestaView(resta : Resta, navController: NavController, viewModel: RsViewModel){

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Text(text = resta.name)
    }
}
