package com.example.hilt.data.database.cache

import com.example.hilt.data.repository.CacheRepositoryImpl
import com.example.hilt.domain.repository.CacheRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface CacheModule {
    @Binds
    fun bindsVideoDataSource(cacheRepositoryImpl: CacheRepositoryImpl) : CacheRepository
}