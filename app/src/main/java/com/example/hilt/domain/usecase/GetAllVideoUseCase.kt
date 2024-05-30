package com.example.hilt.domain.usecase

import android.util.Log
import com.example.hilt.data.database.entity.LikeVideoModel
import com.example.hilt.domain.entity.DomainLikeVideoEntity
import com.example.hilt.domain.entity.DomainLikeVideoListEntity
import com.example.hilt.domain.repository.CacheRepository
import com.example.hilt.presentation.popular.model.PopularVideo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class GetAllVideoUseCase @Inject constructor(private val cacheRepository: CacheRepository) {
    // LiveData -> Flow : invoke 함수가 바뀜, Flow는 lifecycle을 모르기에 그런듯?
    suspend fun invoke(): Flow<List<DomainLikeVideoEntity>> {
        return cacheRepository.getAllVideo()
    }
}