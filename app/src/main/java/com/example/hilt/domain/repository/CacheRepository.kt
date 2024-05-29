package com.example.hilt.domain.repository

import com.example.hilt.data.database.entity.LikeVideoEntity
import kotlinx.coroutines.flow.Flow

interface CacheRepository {
    suspend fun insertVideo(likeVideoEntity: LikeVideoEntity)
    fun getAllVideo(): Flow<List<LikeVideoEntity>>
}