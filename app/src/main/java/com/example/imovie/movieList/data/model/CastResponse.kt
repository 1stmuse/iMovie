package com.example.imovie.movieList.data.model

data class CastResponse(
    val cast: List<Cast>,
    val crew: List<Crew>,
    val id: Int
)