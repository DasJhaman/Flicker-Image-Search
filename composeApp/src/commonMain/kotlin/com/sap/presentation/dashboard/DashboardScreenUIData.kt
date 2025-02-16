package com.sap.presentation.dashboard

import com.sap.domain.model.Photo
import com.sap.domain.model.SearchHistory
import com.sap.presentation.common.ContentState

data class DashboardScreenUIData(
    val contentState: ContentState = ContentState.SUCCESS,
    val photo: List<Photo> = emptyList(),
    val searchQuery: String? = null,
    val searchExpanded: Boolean = false,
    val searchHistory: List<SearchHistory> = emptyList()
)