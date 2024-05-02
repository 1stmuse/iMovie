package com.example.imovie.movieList.di

import com.example.imovie.movieList.data.remote.movieApi
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

}