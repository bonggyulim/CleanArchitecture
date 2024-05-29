package com.example.hilt.domain.usecase

import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.domain.repository.CacheRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllVideoUseCase @Inject constructor(private val cacheRepository: CacheRepository) {
    // LiveData -> Flow : invoke 함수가 바뀜, Flow는 lifecycle을 모르기에 그런듯?
    fun invoke(): Flow<List<LikeVideoEntity>> {
        return cacheRepository.getAllVideo()
    }
}