package com.example.hilt.data.remote.di

import com.example.hilt.data.repository.PopularRepositoryImpl
import com.example.hilt.domain.repository.PopularRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface VideoModule {
    @Binds
    fun bindsPopularRepository(popularRepositoryImpl: PopularRepositoryImpl) : PopularRepository
}