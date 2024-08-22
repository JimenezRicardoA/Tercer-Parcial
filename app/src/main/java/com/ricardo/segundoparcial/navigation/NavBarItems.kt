package com.ricardo.segundoparcial.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Call

val NavBarItems = listOf(
    BarItem(
        title = "Training",
        image = Icons.Filled.AccountBox,
        route = Routes.FirstParcialView
    ),
    BarItem(
        title = "Clubs",
        image = Icons.Filled.AccountBox,
        route = Routes.SecondParcialView
    ),
    BarItem(
        title = "Scoreboard",
        image = Icons.Filled.Call,
        route = Routes.ThirdParcialView
    )
)