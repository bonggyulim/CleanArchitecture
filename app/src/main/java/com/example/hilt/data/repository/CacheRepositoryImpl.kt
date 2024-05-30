package com.example.hilt.data.repository

import com.example.hilt.data.database.LikeVideoDAO
import com.example.hilt.data.mapper.toEntity
import com.example.hilt.data.mapper.toModel
import com.example.hilt.domain.entity.DomainLikeVideoEntity
import com.example.hilt.domain.repository.CacheRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CacheRepositoryImpl @Inject constructor(
    private val likeVideoDAO: LikeVideoDAO
): CacheRepository {
    override suspend fun insertVideo(likeVideoEntity: DomainLikeVideoEntity) {
        likeVideoDAO.insertVideo(likeVideoEntity.toModel())
    }

    override suspend fun getAllVideo(): Flow<List<DomainLikeVideoEntity>> {
        return likeVideoDAO.getAllVideo().map { list ->
            list.map {
                it.toEntity()
            }
        }
    }
}