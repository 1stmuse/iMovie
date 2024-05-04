package com.example.imovie.movieDetail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imovie.movieList.domain.useCases.MovieListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieListUseCases: MovieListUseCases
): ViewModel() {

    private val _uiState = MutableStateFlow(MovieUiState())
    val uiState = _uiState.asStateFlow()


    fun getDetails(id: Int){
        _uiState.update {
            it.copy(loading = true)
        }
        viewModelScope.launch {
            val movie = movieListUseCases.getMovieDetail(id)
            _uiState.update {
                it.copy(
                    loading = false,
                    movie = movie
                )
            }
        }
    }
}