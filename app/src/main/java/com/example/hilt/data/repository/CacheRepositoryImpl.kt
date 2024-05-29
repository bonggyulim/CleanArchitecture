package com.example.hilt.data.repository

import com.example.hilt.data.database.LikeVideoDAO
import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.domain.repository.CacheRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val likeVideoDAO: LikeVideoDAO
): CacheRepository {
    override suspend fun insertVideo(likeVideoEntity: LikeVideoEntity) {
        likeVideoDAO.insertVideo(likeVideoEntity)
    }

    override fun getAllVideo(): Flow<List<LikeVideoEntity>> {
        return likeVideoDAO.getAllVideo()
    }

}