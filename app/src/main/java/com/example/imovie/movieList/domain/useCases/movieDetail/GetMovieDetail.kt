package com.example.imovie.movieList.domain.useCases.movieDetail

import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.domain.repository.MovieRepository

class GetMovieDetail(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(id: Int): Movie {
        return movieRepository.getMovieDetails(id)
    }
}