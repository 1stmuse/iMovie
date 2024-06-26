package com.example.imovie.movieList.domain.useCases.movielist

import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetPopularMovies(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(): Flow<List<Movie>> {
        return movieRepository.getMovies("popular", 1)
    }
}