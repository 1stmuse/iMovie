package com.example.imovie.movieList.data.repositoryImpl

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.imovie.movieList.data.model.Movie
import com.example.imovie.movieList.data.remote.MoviePagingSource
import com.example.imovie.movieList.data.remote.movieApi
import com.example.imovie.movieList.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val movieApi: movieApi
): MovieRepository {
    override suspend fun getAllCategoryMovies(
        category: String,
        page: Int
    ): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = {
                MoviePagingSource(movieApi, category)
            }
        ).flow
    }

    override suspend fun getMovies(category: String, page: Int): Flow<List<Movie>> {
        return flow {
            emit(movieApi.getMovies(category, page).results)
        }
    }

    override suspend fun getMovieDetails(id: Int): Movie {
        return  movieApi.getMovieDetails((id))
    }

    override suspend fun searchMovie(title: String): Flow<List<Movie>> {
        return flow {
            Log.d("MOVIES", "${movieApi.searchMovie(title).results} movies ooo")
            emit(movieApi.searchMovie(title).results)
        }
    }

}