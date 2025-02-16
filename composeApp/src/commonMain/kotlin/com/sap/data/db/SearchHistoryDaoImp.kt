package com.sap.data.db

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import comsapflickersearchdb.SearchHistory
import comsapflickersearchdb.SearchHistoryTableQueries
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Clock

class SearchHistoryDaoImp(private val searchHistoryTableQueries: SearchHistoryTableQueries) :
    SearchHistoryDao {

    override suspend fun upsertSearchHistory(query: String) {
        searchHistoryTableQueries.upsertSearchHistory(
            query = query,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }

    override fun getAllSearchHistory(): Flow<List<SearchHistory>> =
        searchHistoryTableQueries.selectSearchHistory().asFlow().mapToList(Dispatchers.IO)


    override suspend fun deleteSearchById(id: Long) {
        searchHistoryTableQueries.deleteSearchHistoryItem(id)
    }

    override suspend fun clearSearchHistory() {
        searchHistoryTableQueries.clearAllSearchHistory()
    }
}