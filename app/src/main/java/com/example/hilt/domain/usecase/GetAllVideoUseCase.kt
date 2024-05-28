package com.example.hilt.domain.usecase

import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.domain.repository.CacheRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetAllVideoUseCase @Inject constructor(private val cacheRepository: CacheRepository) {
    operator fun invoke(
        owner: String,
        scope: CoroutineScope,
        onResult: (List<LikeVideoEntity>) -> Unit = {}
    ) {
        scope.launch {
            onResult(cacheRepository.getAllVideo())
        }
    }
}