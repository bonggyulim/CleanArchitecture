package com.example.hilt.presentation.popular.model

data class PopularVideoList(val items: List<PopularVideo>)
data class PopularVideo(
    val id: String,
    val title: String?,
    val ChannelId: String?,
    val thumbnails: String?,
    val isLiked: Boolean = false
)