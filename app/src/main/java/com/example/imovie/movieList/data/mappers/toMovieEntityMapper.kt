package com.example.imovie.movieList.data.mappers

import com.example.imovie.movieList.data.local.model.MovieEntity
import com.example.imovie.movieList.data.model.Movie


fun Movie.toMovieEntity(): MovieEntity {

    return MovieEntity(
        movieId = id,
        year = release_date,
        image = backdrop_path
    )
}