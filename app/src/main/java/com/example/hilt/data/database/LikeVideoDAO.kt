package com.example.hilt.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt.data.database.entity.LikeVideoModel
import com.example.hilt.domain.entity.DomainLikeVideoListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LikeVideoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVideo(myFavoriteVideo: LikeVideoModel)

    @Query("SELECT * FROM video_table")
    fun getAllVideo(): Flow<List<LikeVideoModel>>
}
