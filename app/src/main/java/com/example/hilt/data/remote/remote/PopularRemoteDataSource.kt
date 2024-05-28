package com.example.hilt.data.remote.remote

import com.example.hilt.data.remote.model.PopularVideoListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PopularRemoteDataSource {
    @GET("videos")
    suspend fun getPopularVideoList(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("chart") chart: String,
        @Query("maxResults") maxResults: Int,
    ): PopularVideoListResponse
}