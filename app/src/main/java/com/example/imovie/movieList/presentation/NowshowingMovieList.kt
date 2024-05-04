package com.example.imovie.movieList.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.presentation.components.MovieCard


@Composable
fun NowShowingMovieList(
    movies: List<Movie>,
    onItemClick: (id: Int) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Text(text = "New and Noteworthy", color = Color.White, style = MaterialTheme.typography.titleLarge )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ){
            items(movies){ item ->
                MovieCard(movie = item, onClick = {
                    onItemClick(item.id)
                })
            }
        }
    }
}