package com.ricardo.segundoparcial.navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavBarView(navController: NavController) {
    BottomAppBar(containerColor = Color(0xFF55E4FB)) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title,
                        tint = Color.White
                    )
                },
                label = {
                    Text(text = navItem.title,
                        color = Color.White
                    )
                }
            )
        }
    }
}