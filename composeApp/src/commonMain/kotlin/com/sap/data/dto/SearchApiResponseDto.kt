package com.sap.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class SearchApiResponseDto(
    val photos: PhotosDto? = null,
)

@Serializable
data class PhotosDto(
    val page: Int,
    val pages: Long,
    @SerialName("perpage")
    val perPage: Int,
    val total: Long,
    val photo: List<PhotoDto>? = null,
)

@Serializable
data class PhotoDto(
    @SerialName("id")
    val photoId: String,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    val farm: Int,
    @SerialName("ispublic")
    val isPublic: Int,
    @SerialName("isfriend")
    val isFriend: Int,
    @SerialName("isfamily")
    val isFamily: Int,
)