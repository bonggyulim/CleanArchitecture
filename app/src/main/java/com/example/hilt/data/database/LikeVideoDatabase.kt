package com.example.hilt.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilt.data.database.entity.LikeVideoEntity

@Database(entities = [LikeVideoEntity::class], version = 1)
abstract class LikeVideoDatabase : RoomDatabase() {
    abstract fun getDao(): LikeVideoDAO
}