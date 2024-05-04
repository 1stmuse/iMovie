package com.example.imovie.core.presentation.favourites

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun FavouritesScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
            .padding(top = 40.dp)
    ) {
        Text(text = "Settings screen", color = Color.White)
    }
}