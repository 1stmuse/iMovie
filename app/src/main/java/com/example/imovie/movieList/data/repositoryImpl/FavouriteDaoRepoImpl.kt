package com.example.imovie.movieList.data.repositoryImpl

import com.example.imovie.movieList.data.local.Dao.FavouriteDao
import com.example.imovie.movieList.data.local.model.MovieEntity
import com.example.imovie.movieList.data.mappers.toMovieEntity
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.domain.repository.FavouriteDaoRepository
import kotlinx.coroutines.flow.Flow

class FavouriteDaoRepoImpl(
    private val favouriteDao: FavouriteDao
): FavouriteDaoRepository {
    override suspend fun getMovie(movieId: Int): MovieEntity {
        return favouriteDao.getMovie(movieId)
    }

    override fun getAllFavouriteMovie(): Flow<List<MovieEntity>> {
        return favouriteDao.getAllFavourites()
    }

    override suspend fun addToFavourite(movie: Movie) {
        favouriteDao.addToFavourite(movie.toMovieEntity())
    }

    override suspend fun removeFromFavourite(movieId: Int) {
        favouriteDao.deleteFromFavourite(movieId)
    }
}