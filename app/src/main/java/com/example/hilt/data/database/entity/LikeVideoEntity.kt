package com.example.hilt.data.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "video_table")
@Parcelize
class LikeVideoEntity (
    @PrimaryKey
    @ColumnInfo(name = "video_id")
    val id: String,
    val title: String?,
    val ChannelId: String?,
    val thumbnails: String?,
    val isLiked: Boolean?
): Parcelable