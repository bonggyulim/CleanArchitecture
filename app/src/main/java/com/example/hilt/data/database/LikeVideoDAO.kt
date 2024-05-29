package com.example.hilt.data.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.domain.repository.CacheRepository
import com.example.hilt.domain.usecase.GetAllVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@Dao
interface LikeVideoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVideo(myFavoriteVideo: LikeVideoEntity)

    @Query("SELECT * FROM video_table")
    fun getAllVideo(): Flow<MutableList<LikeVideoEntity>>
}
