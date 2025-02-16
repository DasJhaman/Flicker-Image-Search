package com.sap.data.repo

import com.sap.data.db.SearchHistoryDao
import com.sap.data.remote.SearchApi
import com.sap.data.toSearchApiResponse
import com.sap.data.toSearchHistory
import com.sap.domain.model.SearchResponse
import com.sap.domain.SearchRepository
import com.sap.domain.model.SearchHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SearchRepositoryImp(
    private val searchApi: SearchApi,
    private val searchHistoryDao: SearchHistoryDao
) : SearchRepository {

    override suspend fun getAllSearchHistory(): Flow<List<SearchHistory>> {
        return searchHistoryDao.getAllSearchHistory().map { it.toSearchHistory() }
    }

    override suspend fun searchPhotos(searchTerm: String): RepositoryResult<SearchResponse> {
        searchHistoryDao.upsertSearchHistory(searchTerm)
        return searchApi.search(searchTerm = searchTerm).fold(onSuccess = {
            RepositoryResult.Success(it.toSearchApiResponse())
        }, onFailure = {
            RepositoryResult.Error(null, it.message ?: it.cause?.message.orEmpty())
        })
    }
}