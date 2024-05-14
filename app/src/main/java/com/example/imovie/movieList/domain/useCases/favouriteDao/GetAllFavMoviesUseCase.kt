package com.example.imovie.movieList.domain.useCases.favouriteDao

import com.example.imovie.movieList.data.local.model.MovieEntity
import com.example.imovie.movieList.domain.repository.FavouriteDaoRepository
import kotlinx.coroutines.flow.Flow

class GetAllFavMoviesUseCase(
    private val favouriteDaoRepository: FavouriteDaoRepository
) {

    operator fun invoke(): Flow<List<MovieEntity>>{
        return favouriteDaoRepository.getAllFavouriteMovie()
    }
}