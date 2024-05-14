package com.example.imovie.movieList.data.local.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.imovie.movieList.data.local.model.MovieEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface FavouriteDao {
    @Upsert
    suspend fun addToFavourite(movie: MovieEntity)

    @Query("SELECT * FROM MovieEntity WHERE movieId=:movieId")
    suspend fun getMovie(movieId: Int): MovieEntity

    @Query("SELECT * FROM MovieEntity")
    fun getAllFavourites(): Flow<List<MovieEntity>>

    @Query("DELETE FROM MovieEntity WHERE movieId = :movieId")
    suspend fun deleteFromFavourite(movieId: Int)
}