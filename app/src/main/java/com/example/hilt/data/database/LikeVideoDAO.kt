package com.example.hilt.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt.data.database.entity.LikeVideoEntity

@Dao
interface LikeVideoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVideo(myFavoriteVideo: LikeVideoEntity)

    @Query("SELECT * FROM video_table")
    suspend fun getAllVideo(): MutableList<LikeVideoEntity>
}