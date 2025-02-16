package com.sap.domain

import com.sap.data.repo.RepositoryResult
import com.sap.domain.model.SearchHistory
import com.sap.domain.model.SearchResponse
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    suspend fun getAllSearchHistory(): Flow<List<SearchHistory>>
    suspend fun searchPhotos(searchTerm: String): RepositoryResult<SearchResponse>

}