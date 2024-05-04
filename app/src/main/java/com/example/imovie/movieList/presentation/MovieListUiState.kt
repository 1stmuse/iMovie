package com.example.imovie.movieList.presentation

import com.example.imovie.movieList.data.model.Movie

data class MovieListUiState(
    val popularMovies: List<Movie> = emptyList(),
    val nowShowingMovies: List<Movie> = emptyList(),
    val upcomingMovies: List<Movie> = emptyList(),
    val loading: Boolean? = false
)
