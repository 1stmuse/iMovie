package com.example.imovie.core.presentation.search

import com.example.imovie.movieList.data.model.Movie

data class SearchScreenUiState(
    val searchTerm: String = "",
    val movies: List<Movie> = emptyList(),
    val loading: Boolean = false
)
