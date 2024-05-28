package com.example.hilt.domain.repository

import com.example.hilt.data.database.entity.LikeVideoEntity

interface CacheRepository {
    suspend fun insertVideo(likeVideoEntity: LikeVideoEntity)
    suspend fun getAllVideo(): List<LikeVideoEntity>
}