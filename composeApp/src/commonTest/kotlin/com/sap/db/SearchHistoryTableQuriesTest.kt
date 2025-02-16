package com.sap.db

import comsapflickersearchdb.SearchHistoryTableQueries
import kotlinx.coroutines.runBlocking
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SearchHistoryTableQuriesTest: DatabaseQueriesTest() {
    private lateinit var searchHistoryTableQueries: SearchHistoryTableQueries

    @BeforeTest
    override fun beforeTest() {
        super.beforeTest()
        searchHistoryTableQueries = dbRef.searchHistoryTableQueries
    }

    @Test
    fun insert_search_history_should_store_data() = runBlocking {
        searchHistoryTableQueries.upsertSearchHistory("testQuery", timestamp = 123)

        val result = searchHistoryTableQueries.selectSearchHistory().executeAsList()
        assertEquals(1, result.size)
        assertEquals("testQuery", result.first().query)
    }

    @Test
    fun search_history_should_return_unique_values() = runBlocking {
        searchHistoryTableQueries.upsertSearchHistory("hello",12)
        searchHistoryTableQueries.upsertSearchHistory("hello",123)
        searchHistoryTableQueries.upsertSearchHistory("world",123)

        val result = searchHistoryTableQueries.selectSearchHistory().executeAsList()
        assertEquals(2, result.size)
        assertTrue(result.any { it.query == "hello" })
        assertTrue(result.any { it.query == "world" })
    }

    @Test
    fun delete_search_history_by_id_should_remove_specific_entry() = runBlocking {
        searchHistoryTableQueries.upsertSearchHistory("test1",123)
        searchHistoryTableQueries.upsertSearchHistory("test2",123)

        val allHistory = searchHistoryTableQueries.selectSearchHistory().executeAsList()
        val idToDelete = allHistory.first().id

        searchHistoryTableQueries.deleteSearchHistoryItem(idToDelete)

        val result = searchHistoryTableQueries.selectSearchHistory().executeAsList()
        assertEquals(1, result.size)
        assertFalse(result.any { it.id == idToDelete })
    }

    @Test
    fun clearSearchHistory_should_remove_all_entries() = runBlocking {
        searchHistoryTableQueries.upsertSearchHistory("test1",123)
        searchHistoryTableQueries.upsertSearchHistory("test2",123)

        searchHistoryTableQueries.clearAllSearchHistory()

        val result = searchHistoryTableQueries.selectSearchHistory().executeAsList()
        assertTrue(result.isEmpty())
    }
}