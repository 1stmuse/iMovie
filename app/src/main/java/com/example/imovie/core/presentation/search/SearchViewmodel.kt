package com.example.imovie.core.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imovie.movieList.domain.useCases.movielist.MovieListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewmodel @Inject constructor(
    private val movieListUseCases: MovieListUseCases
) : ViewModel() {

    private val _uiState = MutableStateFlow(SearchScreenUiState())

    val uiState = _uiState.asStateFlow()

    fun searchMovie(events: UiEvents){
        when(events){
            is UiEvents.OnChange -> {
                _uiState.update {
                    it.copy(searchTerm = events.searchTerm)
                }
                searchMovies(events.searchTerm)
            }
        }
    }

    private fun searchMovies(title: String){
        viewModelScope.launch {
            movieListUseCases.searchMovieUsecase(title).collectLatest { movies ->
                _uiState.update {
                    it.copy(
                        movies = movies
                    )
                }
            }
        }
    }
}