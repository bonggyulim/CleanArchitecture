package com.example.hilt.presentation.popular.mapper

import com.example.hilt.domain.entity.DomainLikeVideoEntity
import com.example.hilt.domain.entity.DomainPopularVideoEntity
import com.example.hilt.domain.entity.DomainPopularVideoList
import com.example.hilt.presentation.popular.model.PopularVideo
import com.example.hilt.presentation.popular.model.PopularVideoList

fun DomainPopularVideoList.toModel() = PopularVideoList(
    items = items.toModel()
)

fun List<DomainPopularVideoEntity>.toModel(): List<PopularVideo> {
    return map {
        PopularVideo(
            it.id,
            it.title,
            it.ChannelId,
            it.thumbnails
        )
    }
}


fun PopularVideo.toEntity(): DomainLikeVideoEntity {
    return DomainLikeVideoEntity(
        id = id,
        title = title,
        ChannelId = ChannelId,
        thumbnails = thumbnails,
        isLiked = isLiked
    )
}

fun List<DomainLikeVideoEntity>.toModel(): List<PopularVideo> {
    return map {
        PopularVideo(
            it.id,
            it.title,
            it.ChannelId,
            it.thumbnails,
            it.isLiked
        )
    }
}

