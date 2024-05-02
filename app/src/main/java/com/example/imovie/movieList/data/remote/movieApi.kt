package com.example.imovie.movieList.data.remote

import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.data.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface movieApi {

    @GET("movieList")
    suspend fun getMovies(
        @Path("category") category: String,
        @Query("page") page: Number
    ): Response

    @GET("movieList")
    suspend fun getMovieDetails(
        @Path("id") id: Int
    ): Movie
}