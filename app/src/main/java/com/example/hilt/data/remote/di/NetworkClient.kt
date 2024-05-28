package com.example.hilt.data.remote.di

import com.example.hilt.data.remote.remote.PopularRemoteDataSource
import com.example.hilt.data.remote.retrofit.HttpRequestIntercepter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

val BASE_URL = "https://www.googleapis.com/youtube/v3/"
@Module
@InstallIn(SingletonComponent::class)
internal object NetworkClient {
    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val loggingIntercepter = HttpLoggingInterceptor()
        loggingIntercepter.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient
            .Builder()
            .addInterceptor(HttpRequestIntercepter())
            .addNetworkInterceptor(loggingIntercepter)
            .build()
    }

    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesPopularVideoRemoteDataSource(retrofit: Retrofit): PopularRemoteDataSource {
        return retrofit.create(PopularRemoteDataSource::class.java)
    }
}