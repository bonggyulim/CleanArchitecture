package com.example.hilt.domain.entity

data class DomainPopularVideoList(val items: List<DomainPopularVideo>)
data class DomainPopularVideo(
    val id: String,
    val title: String?,
    val ChannelId: String?,
    val thumbnails: String?,
    val isLiked: Boolean = false
)