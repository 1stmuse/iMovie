package com.example.imovie.movieDetail.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.imovie.common.Header

@Composable
fun MovieDetailScreen(
    navController: NavController,
    movieId: String
) {
    val vm: MovieDetailViewModel = hiltViewModel()
    val uiState = vm.uiState.collectAsState().value
    val movie = uiState.movie

    LaunchedEffect(key1 = 1){
        vm.getDetails(movieId.toInt())
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp)
            .padding(horizontal = 20.dp)

    ) {
        Header(
            leftfIcon = {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = Color.White, modifier = Modifier.clickable {
                    navController.popBackStack()
                } )
            },
            title = movie?.title ?: "Movie Title"
        )
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {

            if(uiState.loading){
                CircularProgressIndicator()
            } else {
                Text(text = movie?.title ?: "", color = Color.White)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Realease Year", color = Color.White)
                        Text(text = movie?.release_date?.take(4) ?: "", color = Color.White)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Language", color = Color.White)
                        Text(text = movie?.original_language ?: "", color = Color.White)
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Rating", color = Color.White)
                        Text(text = if(movie?.adult ?: false) "18+" else "PG-13", color = Color.White)
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = movie?.overview ?: "", color = Color.White)
            }

        }
    }

}