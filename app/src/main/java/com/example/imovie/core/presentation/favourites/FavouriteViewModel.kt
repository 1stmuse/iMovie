package com.example.imovie.core.presentation.favourites

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imovie.movieList.data.local.model.MovieEntity
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.domain.useCases.favouriteDao.FavouriteDaoUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val favouriteDaoUseCases: FavouriteDaoUseCases
): ViewModel() {

    private val _favourites = MutableStateFlow<List<MovieEntity>>(emptyList())
    val favourites = _favourites.asStateFlow()


    init {
        getAllFavMovies()
    }

    private fun getAllFavMovies(){
       viewModelScope.launch {
           favouriteDaoUseCases.getAllFavMoviesUseCase().collectLatest { favs ->
               _favourites.value = favs
           }
       }
    }

    fun toggleToFav(movie: Movie){
        val isFav = favourites.value.any { it.movieId == movie.id }
        if(isFav) {
            Log.d("FAV", "removing movie from DB ${movie.id}")
            removeFav(movie)
        }else {
            Log.d("FAV", "adding movie from DB ${movie.id}")
            addToFav(movie)
        }

    }

     fun addToFav(movie: Movie){
        viewModelScope.launch {
            favouriteDaoUseCases.addFavMovieUseCase(movie)
        }

    }

     fun removeFav(movie: Movie){
        viewModelScope.launch {
            favouriteDaoUseCases.removeFavMovieUseCase(movie)
        }

    }

}