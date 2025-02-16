package com.sap.domain.usecase

import com.sap.domain.SearchRepository

class GetAllSearchHistoryUseCase(private val searchRepository: SearchRepository) {
    suspend operator fun invoke() = searchRepository.getAllSearchHistory()
}