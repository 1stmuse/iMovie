package com.example.imovie.movieList.domain.useCases

import android.util.Log
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetUpcomingMovies(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getMovies("upcoming", 1)
    }
}