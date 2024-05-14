package com.example.imovie.movieList.domain.useCases.favouriteDao

data class FavouriteDaoUseCases(
    val addFavMovieUseCase: AddFavMovieUseCase,
    val removeFavMovieUseCase: RemoveFavMovieUseCase,
    val getFavMovieUseCase: GetFavMovieUseCase,
    val getAllFavMoviesUseCase: GetAllFavMoviesUseCase
)
