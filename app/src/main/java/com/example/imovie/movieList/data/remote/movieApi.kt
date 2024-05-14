package com.example.imovie.movieList.data.remote

import com.example.imovie.movieList.data.model.CastResponse
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.data.model.Response
import com.example.imovie.movieList.data.model.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface movieApi {

    @GET("movie/{category}")
    suspend fun getMovies(
        @Path("category") category: String,
        @Query("page") page: Number
    ): Response

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int
    ): Movie

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("query") title: String
    ): Response

    @GET("movie/{movieId}/credits")
    suspend fun getMovieCast(
        @Path("movieId") id: Int
    ): CastResponse

    @GET("movie/{movieId}/videos")
    suspend fun getMovieVideo(
        @Path("movieId") id: Int
    ): VideoResponse

}