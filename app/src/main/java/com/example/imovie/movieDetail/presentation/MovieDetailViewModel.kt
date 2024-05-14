package com.example.imovie.movieDetail.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imovie.movieList.domain.useCases.movieDetail.MovieDetailUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCases: MovieDetailUseCases
): ViewModel() {

    private val _uiState = MutableStateFlow(MovieUiState())
    val uiState = _uiState.asStateFlow()


    fun getDetails(id: Int){
        _uiState.update {
            it.copy(loading = true)
        }
        viewModelScope.launch {
            val movie = movieDetailUseCases.getMovieDetail(id)
            movieDetailUseCases.getMovieCast(id).collectLatest { cast ->
                _uiState.update {
                    it.copy(
                        loading = false,
                        movie = movie,
                        cast = cast,
                    )
                }
            }

        }

        viewModelScope.launch {
            movieDetailUseCases.getMovieVideos(id).collectLatest { videos ->
                _uiState.update {
                    it.copy(
                        loading = false,
                        videos = videos
                    )
                }
            }
        }


    }
}