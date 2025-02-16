package com.sap.presentation.dashboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sap.domain.model.Photo
import com.sap.domain.model.SearchHistory
import com.sap.presentation.common.ContentState
import com.sap.presentation.components.GenericError
import com.sap.presentation.components.GenericLoading
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun DashboardScreen() {
    val dashboardScreenViewModel = koinViewModel<DashboardScreenViewModel>()
    val uiData = dashboardScreenViewModel.uiData.collectAsStateWithLifecycle().value

    DashboardScreenStateLess(
        contentState = uiData.contentState,
        query = uiData.searchQuery,
        searchExpanded = uiData.searchExpanded,
        searchHistory = uiData.searchHistory,
        photo = uiData.photo,
        onRetryClicked = dashboardScreenViewModel::search,
        onSearchQueryChange = dashboardScreenViewModel::updateSearchQuery,
        onExpandedChange = dashboardScreenViewModel::onSearchExpandedChange,
        onSearchQueryClick = dashboardScreenViewModel::search
    )
}

@Composable
fun DashboardScreenStateLess(
    modifier: Modifier = Modifier,
    contentState: ContentState,
    query: String?,
    searchExpanded: Boolean,
    searchHistory: List<SearchHistory>,
    photo: List<Photo>,
    onExpandedChange: (Boolean) -> Unit,
    onSearchQueryChange: (String) -> Unit = {},
    onSearchQueryClick: () -> Unit,
    onRetryClicked: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            DashboardSearchBar(
                query = query,
                searchExpanded = searchExpanded,
                searchHistory = searchHistory,
                onExpandedChange = onExpandedChange,
                onSearchQueryChange = onSearchQueryChange,
                onSearchQueryClick = onSearchQueryClick
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            when (contentState) {
                ContentState.LOADING -> GenericLoading()
                ContentState.ERROR -> GenericError(onRetryClicked = onRetryClicked)
                ContentState.SUCCESS -> {
                    DashboardScreenContentLoaded(
                        photo = photo,
                        onSearchClicked = { onExpandedChange(true) }
                    )
                }
            }
        }
    }
}