package com.example.hilt.data.database.di

import android.app.Application
import androidx.room.Room
import com.example.hilt.data.database.LikeVideoDAO
import com.example.hilt.data.database.LikeVideoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DataBaseModule {
    @Provides
    fun provideLikeVideoDataBase(application: Application) : LikeVideoDatabase {
        return Room.databaseBuilder(
            application,
            LikeVideoDatabase::class.java,
            "video_database"
        ).build()
    }

    @Provides
    fun provideLikeVideoDao (appDatabase : LikeVideoDatabase) : LikeVideoDAO {
        return appDatabase.getDao()
    }

}
