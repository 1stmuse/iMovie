package com.example.imovie.movieList.domain.useCases.movieDetail

import com.example.imovie.movieList.data.model.Video
import com.example.imovie.movieList.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovieVideos(
    private val movieRepository: MovieRepository
) {

    suspend operator fun invoke(id:Int): Flow<List<Video>>{
        return  movieRepository.getMovieVideos(id)
    }
}