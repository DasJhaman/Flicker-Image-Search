package com.sap.data

import com.sap.data.dto.PhotoDto
import com.sap.data.dto.PhotosDto
import com.sap.data.dto.SearchApiResponseDto
import com.sap.domain.model.Photo
import com.sap.domain.model.Photos
import com.sap.domain.model.SearchResponse

fun PhotoDto.toPhoto() = Photo(
    photoId = photoId,
    owner = owner,
    title = title,
    isPublic = isPublic == 1,
    isFriend = isFriend == 1,
    isFamily = isFamily == 1,
    imageUrl = generateImageUrl()
)

fun List<PhotoDto>.toPhoto() = map { it.toPhoto() }

fun SearchApiResponseDto.toSearchApiResponse() =
    SearchResponse(photos = photos?.toPhotos())

fun PhotosDto.toPhotos() = Photos(
    page = page,
    pages = pages,
    perPage = perPage,
    total = total,
    photo = photo?.toPhoto()
)

fun PhotoDto.generateImageUrl(): String {
    return "https://farm$farm.static.flickr.com/$server/${photoId}_$secret.jpg"
}