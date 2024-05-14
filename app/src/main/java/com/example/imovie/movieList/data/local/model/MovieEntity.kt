package com.example.imovie.movieList.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val movieId: Int,
    val year: String,
    val image: String
)