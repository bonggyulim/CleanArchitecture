package com.example.hilt.domain.repository

import com.example.hilt.domain.entity.DomainPopularVideoList

interface PopularRepository {
    suspend fun getPopularVideoList(
        AUTH_KEY: String,
        part: String,
        chart: String,
        maxResults: Int
    ): DomainPopularVideoList
}