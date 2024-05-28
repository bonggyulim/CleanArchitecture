package com.example.hilt.data.mapper

import com.example.hilt.data.remote.model.PopularVideoListResponse
import com.example.hilt.data.remote.model.PopularVideoResponse
import com.example.hilt.domain.entity.DomainPopularVideo
import com.example.hilt.domain.entity.DomainPopularVideoList
import com.example.hilt.presentation.popular.model.PopularVideo
import com.example.hilt.presentation.popular.model.PopularVideoList

fun PopularVideoListResponse.toDomainEntity() = DomainPopularVideoList(
    items = items.asLikeVideoEntity()
)

fun List<PopularVideoResponse>.asLikeVideoEntity(): List<DomainPopularVideo> {
    return map {
        DomainPopularVideo(
            it.id,
            it.snippet.title,
            it.snippet.channelTitle,
            it.snippet.thumbnails.default.url
        )
    }
}
