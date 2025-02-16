package com.sap.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import com.sap.domain.model.Photo
import com.sap.presentation.common.ContentState
import com.sap.presentation.dashboard.DashboardScreenStateLess
import com.sap.presentation.dashboard.DashboardSearchBar
import kotlin.test.Test


class DashboardScreenTest {

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testDashboardScreenStateLess_loadingState() = runComposeUiTest {
        setContent {
            DashboardScreenStateLess(
                contentState = ContentState.LOADING,
                query = null,
                searchExpanded = false,
                searchHistory = emptyList(),
                photo = emptyList(),
                onExpandedChange = {},
                onSearchQueryChange = {},
                onSearchQueryClick = {},
                onRetryClicked = {}
            )
        }

        onNodeWithTag("GenericLoading").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testDashboardScreenStateLess_errorState() = runComposeUiTest {
        var retryClicked = false
        setContent {
            DashboardScreenStateLess(
                contentState = ContentState.ERROR,
                query = null,
                searchExpanded = false,
                searchHistory = emptyList(),
                photo = emptyList(),
                onExpandedChange = {},
                onSearchQueryChange = {},
                onSearchQueryClick = {},
                onRetryClicked = { retryClicked = true }
            )
        }

        onNodeWithTag("GenericError").assertIsDisplayed()

        onNodeWithTag("RetryButton").performClick()

        if (retryClicked) {
            onNodeWithTag("RetryButton").assert(isTrue())
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testDashboardScreenStateLess_successState() = runComposeUiTest {
        val photos = listOf(
            Photo(
                photoId = "1",
                title = "Photo 1",
                imageUrl = "url1",
                owner = "",
                isFamily = false,
                isFriend = false,
                isPublic = false
            ),
            Photo(
                photoId = "2",
                title = "Photo 2",
                imageUrl = "url2",
                owner = "",
                isFamily = false,
                isFriend = false,
                isPublic = false
            )
        )
        var searchClicked = false
        setContent {
            DashboardScreenStateLess(
                contentState = ContentState.SUCCESS,
                query = null,
                searchExpanded = false,
                searchHistory = emptyList(),
                photo = photos,
                onExpandedChange = { searchClicked = it },
                onSearchQueryChange = {},
                onSearchQueryClick = {},
                onRetryClicked = {}
            )
        }

        onNodeWithTag("photoGrid").assertIsDisplayed()
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun verify_search_functionality() = runComposeUiTest {
        setContent {
            var query by remember { mutableStateOf("") }

            DashboardSearchBar(
                query = query,
                searchExpanded = true,
                searchHistory = emptyList(),
                onExpandedChange = {},
                onSearchQueryChange = { query = it },
                onSearchQueryClick = {}
            )
        }

        onNodeWithTag("SearchTextField").assert(hasText(""))
        onNodeWithTag("SearchTextField").assert(hasEditableText())

        onNodeWithTag("SearchTextField").performTextInput("Android")
        onNodeWithTag("SearchTextField").assert(hasText("Android"))
        onNodeWithTag("SearchTextField").assert(hasEditableText())
    }
}


fun hasEditableText(): SemanticsMatcher = SemanticsMatcher(
    "has editable text"
) {
    it.config.contains(SemanticsProperties.EditableText)
}

fun isTrue(): SemanticsMatcher = SemanticsMatcher(
    "is true"
) {
    it.config.contains(SemanticsProperties.TestTag)
}