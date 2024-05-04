package com.example.imovie.movieDetail.presentation

import com.example.imovie.movieList.data.model.Movie

data class MovieUiState(
    val loading:Boolean = false,
    val movie: Movie? = null
)