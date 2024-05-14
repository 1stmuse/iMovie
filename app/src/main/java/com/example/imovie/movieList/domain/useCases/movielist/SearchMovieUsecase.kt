package com.example.imovie.movieList.domain.useCases.movielist

import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class SearchMovieUsecase(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(title: String): Flow<List<Movie>> {
        return movieRepository.searchMovie(title)
    }
}