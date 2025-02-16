package com.sap.domain.usecase

import com.sap.domain.SearchRepository


class SearchPhotosUseCase(private val searchRepository: SearchRepository) {

    suspend operator fun invoke(searchTerm: String) =
        searchRepository.searchPhotos(searchTerm = searchTerm)
}
