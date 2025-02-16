package com.sap.data.remote

import com.sap.data.dto.SearchApiResponseDto

interface SearchApi {
    suspend fun search(searchTerm: String): Result<SearchApiResponseDto>
}