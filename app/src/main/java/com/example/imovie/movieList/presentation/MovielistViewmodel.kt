package com.example.imovie.movieList.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imovie.movieList.domain.useCases.MovieListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovielistViewmodel @Inject constructor (
    private val movieListUseCases: MovieListUseCases
): ViewModel() {

    private val _uiState = MutableStateFlow(MovieListUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getAllMovies()
    }

    private suspend fun getPopularMovies(){
        viewModelScope.launch {
            movieListUseCases.getPopularMovies().collectLatest { movies ->
                _uiState.update {
                    it.copy(
                        popularMovies = movies,
                        loading = false
                    )
                }
            }
        }
    }

    private suspend fun getNowShowingMovies(){
        viewModelScope.launch {
            movieListUseCases.getNowShowingMovies().collectLatest { movies ->
                _uiState.update {
                    it.copy(
                        nowShowingMovies = movies,
                        loading = false
                    )
                }
            }
        }
    }

    private fun getUpcomingMovies(){
        viewModelScope.launch {
            movieListUseCases.getUpcomingMovies().collectLatest { movies ->
                _uiState.update {
                    it.copy(
                        upcomingMovies = movies,
                        loading = false
                    )
                }
            }
        }
    }

    private fun getAllMovies(){
        _uiState.update {
            it.copy(
                loading = true
            )
        }
        viewModelScope.launch {
            getUpcomingMovies()
            getPopularMovies()
            getNowShowingMovies()
        }
    }

}