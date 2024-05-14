package com.example.imovie.movieList.domain.repository

import com.example.imovie.movieList.data.local.model.MovieEntity
import com.example.imovie.movieList.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface FavouriteDaoRepository {

    suspend fun getMovie(movieId: Int): MovieEntity
    fun getAllFavouriteMovie(): Flow<List<MovieEntity>>

    suspend fun addToFavourite(movie: Movie)

    suspend fun removeFromFavourite(movieId: Int)
}