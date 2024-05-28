package com.example.hilt.data.remote.model

data class PopularVideoListResponse(
    val items: List<PopularVideoResponse>
)

data class PopularVideoResponse(
    val kind: String,
    val etag: String,
    val id: String,
    val snippet: PopularSnippet
)
data class PopularSnippet(
    val publishedAt: String,
    val channelId: String,
    val title: String,
    val description: String,
    val thumbnails: Thumbnails,
    val channelTitle: String,
    val tags: MutableList<String>,
    val categoryId: String,
)

data class Thumbnails(
    val default: Default
)

data class Default(
    val url: String,
    val width: Int,
    val height: Int
)
