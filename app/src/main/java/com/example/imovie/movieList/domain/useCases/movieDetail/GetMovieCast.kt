package com.example.imovie.movieList.domain.useCases.movieDetail

import com.example.imovie.movieList.data.model.Cast
import com.example.imovie.movieList.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieCast(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(id:Int): Flow<List<Cast>>{
        return movieRepository.getMovieCast(id)
    }
}