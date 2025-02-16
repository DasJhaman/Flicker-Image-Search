package com.sap.domain.model

data class SearchResponse(
    val photos: Photos?
)

data class Photos(
    val page: Int,
    val pages: Long,
    val perPage: Int,
    val total: Long,
    val photo: List<Photo>? = null,
)

data class Photo(
    val photoId: String,
    val owner: String,
    val title: String,
    val isPublic: Boolean,
    val isFriend: Boolean,
    val isFamily: Boolean,
    val imageUrl: String
)