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
        onRetryClicked = {},
        photo = uiData.photo,
        searchHistory = uiData.searchHistory,
        onSearchQueryChange = dashboardScreenViewModel::updateSearchQuery,
        query = uiData.searchQuery,
        searchExpanded = uiData.searchExpanded,
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
    onExpandedChange: (Boolean) -> Unit,
    searchHistory: List<SearchHistory>,
    onSearchQueryClick: () -> Unit,
    onSearchQueryChange: (String) -> Unit = {},
    photo: List<Photo>,
    onRetryClicked: () -> Unit,
) {
    Scaffold(
        modifier = modifier, topBar = {
            DashboardSearchBar(
                onSearchQueryChange = onSearchQueryChange,
                query = query,
                searchExpanded = searchExpanded,
                onExpandedChange = onExpandedChange,
                searchHistory = searchHistory,
                onSearchQueryClick = onSearchQueryClick
            )
        }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            when (contentState) {
                ContentState.LOADING -> GenericLoading()
                ContentState.ERROR -> GenericError(onRetryClicked = onRetryClicked)
                ContentState.SUCCESS -> {
                    DashboardScreenContentLoaded(photo = photo,
                        onSearchClicked = { onExpandedChange(true) })
                }
            }

        }
    }
}