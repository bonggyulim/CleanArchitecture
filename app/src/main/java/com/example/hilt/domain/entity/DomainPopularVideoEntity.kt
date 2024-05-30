package com.example.hilt.domain.entity

data class DomainPopularVideoList(val items: List<DomainPopularVideoEntity>)
data class DomainPopularVideoEntity(
    val id: String,
    val title: String?,
    val ChannelId: String?,
    val thumbnails: String?,
    val isLiked: Boolean = false
)