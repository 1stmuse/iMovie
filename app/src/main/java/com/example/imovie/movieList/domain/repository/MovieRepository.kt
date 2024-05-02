package com.example.imovie.movieList.domain.repository

import androidx.paging.PagingData
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.data.model.Response
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getAllCategoryMovies(category: String, page: Int): Flow<PagingData<Movie>>

    suspend fun getMovies(category: String, page: Int): Flow<Response>
    suspend fun getMovieDetails(id: Int): Movie
}