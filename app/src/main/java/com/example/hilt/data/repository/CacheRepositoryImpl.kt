package com.example.hilt.data.repository

import com.example.hilt.data.database.LikeVideoDAO
import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.domain.repository.CacheRepository
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val likeVideoDAO: LikeVideoDAO
): CacheRepository {
    override suspend fun insertVideo(likeVideoEntity: LikeVideoEntity) {
        likeVideoDAO.insertVideo(likeVideoEntity)
    }

    override suspend fun getAllVideo(): List<LikeVideoEntity> {
        return likeVideoDAO.getAllVideo()
    }

}