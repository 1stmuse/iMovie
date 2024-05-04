package com.example.imovie.core.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imovie.movieList.presentation.MovielistViewmodel
import com.example.imovie.movieList.presentation.NowShowingMovieList
import com.example.imovie.movieList.presentation.PopularMovieList
import com.example.imovie.navigation.Destination
import com.example.imovie.ui.theme.DarkPrimary
import com.example.imovie.ui.theme.PrimaryColor
import com.example.imovie.ui.theme.SecondaryColor


@Composable
fun Homescreen(
    navController: NavController
) {
    val vm: MovielistViewmodel = hiltViewModel()
    val uiState = vm.uiState.collectAsState().value
    val popularMovies = uiState.popularMovies
    val upcomingMovies = uiState.upcomingMovies

    if(uiState.loading!!){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(SecondaryColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
            Text(
                text = "Loading Movies...",
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }

    }else {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
        ){
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(bottom = 150.dp)
            ) {

                if(popularMovies.isNotEmpty()){
                    BannerMovie(movie = popularMovies[5])
                }

                Spacer(modifier = Modifier.height(30.dp))
                PopularMovieList(movies = popularMovies, onItemClick = {
                    navController.navigate("${Destination.MovieDetail.baseRoute}/${it}")
                })
                Spacer(modifier = Modifier.height(40.dp))
                NowShowingMovieList(movies = upcomingMovies, onItemClick = {
                    navController.navigate("${Destination.MovieDetail.baseRoute}/${it}")
                } )


            }

        }
    }




}

@Preview(showBackground = true)
@Composable
fun HomePrev() {
    Homescreen(navController = rememberNavController())
}