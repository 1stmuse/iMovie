package com.example.imovie.movieList.domain.useCases.movielist

data class MovieListUseCases(
    val getNowShowingMovies: GetNowShowingMovies,
    val getPopularMovies: GetPopularMovies,
    val getUpcomingMovies: GetUpcomingMovies,
    val searchMovieUsecase: SearchMovieUsecase,

    )
