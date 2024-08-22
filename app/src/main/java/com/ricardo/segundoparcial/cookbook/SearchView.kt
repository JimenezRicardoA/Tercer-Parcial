package com.ricardo.segundoparcial.cookbook

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FoodSelectionScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        // Search bar
        BasicTextField(
            value = "Hamburger",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Protein category
        Text("Protein", color = Color(0xFFFF9800))
        FoodCategoryRow(
            listOf("Beef", "Chicken", "Fish", "Turkey", "Seafood")
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Grains and cereals category
        Text("Grains and cereals", color = Color(0xFFFF9800))
        FoodCategoryRow(
            listOf("Rice", "Paste wheat flour", "Oatmeal", "Corn")
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Vegetables category
        Text("Vegetables", color = Color(0xFFFF9800))
        FoodCategoryRow(
            listOf("Onion", "Potato", "Tomato", "Lettuce", "Cucumber")
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Fruits category
        Text("Fruit", color = Color(0xFFFF9800))
        FoodCategoryRow(
            listOf("Apple", "Banana", "Orange", "Lime", "Avocado")
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Spices and condiments category
        Text("Spices and Condiments", color = Color(0xFFFF9800))
        FoodCategoryRow(
            listOf("Weed", "Salt", "Pepper", "Oregano", "Laurel")
        )
    }
}

@Composable
fun FoodCategoryRow(items: List<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        items.forEach { item ->
            FoodCheckBoxItem(text = item)
        }
    }
}

@Composable
fun FoodCheckBoxItem(text: String) {
    var checked by remember { mutableStateOf(false) }
    Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFoodSelectionScreen() {
    FoodSelectionScreen()
}