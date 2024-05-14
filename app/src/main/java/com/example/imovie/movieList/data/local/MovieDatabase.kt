package com.example.imovie.movieList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.imovie.movieList.data.local.Dao.FavouriteDao
import com.example.imovie.movieList.data.local.model.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun favouriteDao(): FavouriteDao
}