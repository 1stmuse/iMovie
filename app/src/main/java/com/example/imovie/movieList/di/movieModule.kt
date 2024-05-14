package com.example.imovie.movieList.di

import android.app.Application
import androidx.room.Room
import com.example.imovie.movieList.data.local.Dao.FavouriteDao
import com.example.imovie.movieList.data.local.MovieDatabase
import com.example.imovie.movieList.data.remote.movieApi
import com.example.imovie.movieList.data.repositoryImpl.FavouriteDaoRepoImpl
import com.example.imovie.movieList.data.repositoryImpl.MovieRepositoryImpl
import com.example.imovie.movieList.domain.repository.FavouriteDaoRepository
import com.example.imovie.movieList.domain.repository.MovieRepository
import com.example.imovie.movieList.domain.useCases.favouriteDao.AddFavMovieUseCase
import com.example.imovie.movieList.domain.useCases.favouriteDao.FavouriteDaoUseCases
import com.example.imovie.movieList.domain.useCases.favouriteDao.GetAllFavMoviesUseCase
import com.example.imovie.movieList.domain.useCases.favouriteDao.GetFavMovieUseCase
import com.example.imovie.movieList.domain.useCases.favouriteDao.RemoveFavMovieUseCase
import com.example.imovie.movieList.domain.useCases.movieDetail.GetMovieCast
import com.example.imovie.movieList.domain.useCases.movieDetail.GetMovieDetail
import com.example.imovie.movieList.domain.useCases.movieDetail.GetMovieVideos
import com.example.imovie.movieList.domain.useCases.movielist.GetNowShowingMovies
import com.example.imovie.movieList.domain.useCases.movielist.GetPopularMovies
import com.example.imovie.movieList.domain.useCases.movielist.GetUpcomingMovies
import com.example.imovie.movieList.domain.useCases.movieDetail.MovieDetailUseCases
import com.example.imovie.movieList.domain.useCases.movielist.MovieListUseCases
import com.example.imovie.movieList.domain.useCases.movielist.SearchMovieUsecase
import com.example.imovie.utils.CONSTANTS
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object movieModule {

    private val client = OkHttpClient.Builder().apply {
        addInterceptor { chain ->
            val builder = chain.request().newBuilder()
            builder.addHeader("Authorization", "Bearer ${CONSTANTS.API_KEY}")
            chain.proceed(builder.build())
        }
    }.build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return  Retrofit.Builder()
            .baseUrl(CONSTANTS.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): movieApi {
        return  retrofit.create(movieApi::class.java)
    }

    @Singleton
    @Provides
    fun providesMovielistRepo(movieApi: movieApi): MovieRepository = MovieRepositoryImpl(movieApi)

    @Singleton
    @Provides
    fun providesMovieListUseCases(movieRepository: MovieRepository): MovieListUseCases {
        return MovieListUseCases(
            getNowShowingMovies = GetNowShowingMovies(movieRepository),
            getPopularMovies = GetPopularMovies(movieRepository),
            getUpcomingMovies = GetUpcomingMovies(movieRepository),
            searchMovieUsecase = SearchMovieUsecase(movieRepository),
        )
    }

    @Singleton
    @Provides
    fun provideMovieDetailUseCases(movieRepository: MovieRepository): MovieDetailUseCases {
        return MovieDetailUseCases(
            getMovieDetail = GetMovieDetail(movieRepository),
            getMovieCast = GetMovieCast(movieRepository),
            getMovieVideos = GetMovieVideos(movieRepository)
        )
    }

    @Singleton
    @Provides
    fun provideDatabase(application: Application): MovieDatabase{
        return Room.databaseBuilder(application, MovieDatabase::class.java, "movieDb").fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesFavouriteDao(database: MovieDatabase): FavouriteDao  = database.favouriteDao()

    @Singleton
    @Provides
    fun providesFavouriteDaoRepo(favouriteDao: FavouriteDao): FavouriteDaoRepository{
        return FavouriteDaoRepoImpl(favouriteDao)
    }

    @Singleton
    @Provides
    fun providesFavDaoUseCases(favouriteDaoRepository: FavouriteDaoRepository): FavouriteDaoUseCases {
        return FavouriteDaoUseCases(
            getAllFavMoviesUseCase = GetAllFavMoviesUseCase(favouriteDaoRepository),
            getFavMovieUseCase = GetFavMovieUseCase(favouriteDaoRepository),
            removeFavMovieUseCase = RemoveFavMovieUseCase(favouriteDaoRepository),
            addFavMovieUseCase = AddFavMovieUseCase(favouriteDaoRepository)
        )
    }

}