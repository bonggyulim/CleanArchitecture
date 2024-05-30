package com.example.hilt.domain.entity

data class DomainLikeVideoListEntity(
    val items: List<DomainLikeVideoEntity>
)
data class DomainLikeVideoEntity(
    val id: String = "",
    val title: String? = "",
    val ChannelId: String? = "",
    val thumbnails: String? = "",
    val isLiked: Boolean? = false
)
