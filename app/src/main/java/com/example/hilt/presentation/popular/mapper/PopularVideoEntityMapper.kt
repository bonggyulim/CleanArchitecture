package com.example.hilt.presentation.popular.mapper

import com.example.hilt.data.database.entity.LikeVideoEntity
import com.example.hilt.presentation.popular.model.PopularVideo

fun PopularVideo.asLikeVideoEntity(): LikeVideoEntity {
    return LikeVideoEntity(
        id = id,
        title = title,
        ChannelId = ChannelId,
        thumbnails = thumbnails,
        isLiked = isLiked
    )
}