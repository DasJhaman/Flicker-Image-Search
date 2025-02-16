package com.sap.data

import comsapflickersearchdb.SearchHistory
import com.sap.domain.model.SearchHistory as SearchHistoryModel

fun List<SearchHistory>.toSearchHistory() = map { it.toSearchHistory() }

fun SearchHistory.toSearchHistory() =
    SearchHistoryModel(query = query, formattedTimeStamp = timestamp.toFormattedDateTime())