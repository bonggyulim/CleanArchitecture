package com.example.hilt.presentation.popular.mapper

import com.example.hilt.data.remote.model.PopularVideoListResponse
import com.example.hilt.data.remote.model.PopularVideoResponse
import com.example.hilt.domain.entity.DomainPopularVideo
import com.example.hilt.domain.entity.DomainPopularVideoList
import com.example.hilt.presentation.popular.model.PopularVideo
import com.example.hilt.presentation.popular.model.PopularVideoList

fun DomainPopularVideoList.toEntity() = PopularVideoList(
    items = items.asLikeVideoEntity()
)

fun List<DomainPopularVideo>.asLikeVideoEntity(): List<PopularVideo> {
    return map {
        PopularVideo(
            it.id,
            it.title,
            it.ChannelId,
            it.thumbnails
        )
    }
}
