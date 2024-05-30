package com.example.hilt.domain.repository

import com.example.hilt.domain.entity.DomainLikeVideoEntity
import kotlinx.coroutines.flow.Flow

interface CacheRepository {
    suspend fun insertVideo(likeVideoEntity: DomainLikeVideoEntity)
    suspend fun getAllVideo(): Flow<List<DomainLikeVideoEntity>>
}