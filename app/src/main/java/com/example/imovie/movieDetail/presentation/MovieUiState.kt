package com.example.imovie.movieDetail.presentation

import com.example.imovie.movieList.data.model.Cast
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.data.model.Video

data class MovieUiState(
    val loading:Boolean = false,
    val movie: Movie? = null,
    val cast: List<Cast> = emptyList(),
    val videos: List<Video> = emptyList()
)