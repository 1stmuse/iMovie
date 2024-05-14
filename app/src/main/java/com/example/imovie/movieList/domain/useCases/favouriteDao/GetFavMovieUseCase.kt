package com.example.imovie.movieList.domain.useCases.favouriteDao

import com.example.imovie.movieList.data.local.model.MovieEntity
import com.example.imovie.movieList.domain.repository.FavouriteDaoRepository

class GetFavMovieUseCase(
    private val favouriteDaoRepository: FavouriteDaoRepository
) {
    suspend operator fun invoke(movieId: Int): MovieEntity {
        return favouriteDaoRepository.getMovie(movieId)
    }
}