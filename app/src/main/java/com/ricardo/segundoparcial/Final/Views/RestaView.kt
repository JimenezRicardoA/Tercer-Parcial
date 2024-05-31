package com.ricardo.segundoparcial.Final.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import com.ricardo.segundoparcial.Final.Viewmodel.RsViewModel

@Composable
fun RestaView(item: String){

    Column {
        Text(text = "Selected item: $item")
    }
}
