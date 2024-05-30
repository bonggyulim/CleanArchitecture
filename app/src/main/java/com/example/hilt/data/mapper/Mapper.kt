package com.example.hilt.data.mapper

import com.example.hilt.data.database.entity.LikeVideoModel
import com.example.hilt.data.remote.model.PopularVideoListResponse
import com.example.hilt.data.remote.model.PopularVideoResponse
import com.example.hilt.domain.entity.DomainLikeVideoEntity
import com.example.hilt.domain.entity.DomainPopularVideoEntity
import com.example.hilt.domain.entity.DomainPopularVideoList

fun PopularVideoListResponse.toEntity() = DomainPopularVideoList(
    items = items.toEntity()
)

fun List<PopularVideoResponse>.toEntity(): List<DomainPopularVideoEntity> {
    return map {
        DomainPopularVideoEntity(
            it.id,
            it.snippet.title,
            it.snippet.channelTitle,
            it.snippet.thumbnails.default.url
        )
    }
}


fun LikeVideoModel.toEntity(): DomainLikeVideoEntity {
    return DomainLikeVideoEntity(
        id,
        title,
        ChannelId,
        thumbnails,
        isLiked
    )

}


fun DomainLikeVideoEntity.toModel(): LikeVideoModel {
    return LikeVideoModel(
        id,
        title,
        ChannelId,
        thumbnails,
        isLiked
    )
}