package com.sap.data.db

import comsapflickersearchdb.SearchHistory
import kotlinx.coroutines.flow.Flow

interface SearchHistoryDao {
    suspend fun upsertSearchHistory(query: String)
    fun getAllSearchHistory(): Flow<List<SearchHistory>>
    suspend fun deleteSearchById(id: Long)
    suspend fun clearSearchHistory()
}