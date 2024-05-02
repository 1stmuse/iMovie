package com.example.imovie.core.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imovie.ui.theme.PrimaryColor
import com.example.imovie.ui.theme.SecondaryColor


@Composable
fun Homescreen(
    navController: NavController
) {

    Box(modifier = Modifier.fillMaxSize().background(SecondaryColor)){

    }


}

@Preview(showBackground = true)
@Composable
fun HomePrev() {
    Homescreen(navController = rememberNavController())
}