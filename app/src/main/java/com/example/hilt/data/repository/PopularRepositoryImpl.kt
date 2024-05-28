package com.example.hilt.data.repository

import com.example.hilt.data.mapper.toDomainEntity
import com.example.hilt.data.remote.remote.PopularRemoteDataSource
import com.example.hilt.domain.entity.DomainPopularVideoList
import com.example.hilt.domain.repository.PopularRepository
import javax.inject.Inject


class PopularRepositoryImpl @Inject constructor(
    private val popularRemoteDataSource: PopularRemoteDataSource
)
    : PopularRepository {
    override suspend fun getPopularVideoList(
        AUTH_KEY: String,
        part: String,
        chart: String,
        maxResults: Int
    ): DomainPopularVideoList {
        return popularRemoteDataSource.getPopularVideoList(
            AUTH_KEY,
            part,
            chart,
            maxResults
        ).toDomainEntity()
    }
}