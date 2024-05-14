package com.example.imovie.movieList.domain.useCases.favouriteDao

import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.domain.repository.FavouriteDaoRepository

class RemoveFavMovieUseCase(
    private val favouriteDaoRepository: FavouriteDaoRepository
) {

    suspend operator fun invoke(movie: Movie){
        return favouriteDaoRepository.removeFromFavourite(movie.id)
    }
}