package com.example.imovie.movieList.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.imovie.movieList.data.model.Movie
import retrofit2.HttpException
import java.io.IOException

class MoviePagingSource(
    private val movieApi: movieApi,
    val category: String,
): PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageNumber = params.key ?: 1

            val response = movieApi.getMovies(category, pageNumber)
            val totalCount = response.total_results
            val movies = response.results
            val totalMovies = movies.size

            LoadResult.Page(
                data = movies,
                prevKey = null,
                nextKey = if(totalCount == totalMovies) null else pageNumber + 1
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }


}