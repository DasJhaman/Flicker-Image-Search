package com.sap.presentation.dashboard

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.sap.domain.model.SearchHistory
import com.sap.presentation.components.DefaultDivider
import com.sap.presentation.components.DefaultText
import flickerimagesearch.composeapp.generated.resources.Res
import flickerimagesearch.composeapp.generated.resources.ic_history
import flickerimagesearch.composeapp.generated.resources.search_label
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardSearchBar(
    modifier: Modifier = Modifier,
    query: String?,
    searchExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit,
    searchHistory: List<SearchHistory>,
    onSearchQueryClick: () -> Unit,
    onSearchQueryChange: (String) -> Unit = {},
) {
    val padding by animateDpAsState(targetValue = if (searchExpanded) 0.dp else 16.dp)

    SearchBar(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = padding, vertical = 8.dp),
        inputField = {
            SearchBarDefaults.InputField(
                onQueryChange = onSearchQueryChange,
                query = query.orEmpty(),
                onSearch = {
                    onExpandedChange(false)
                    onSearchQueryClick()
                },
                expanded = searchExpanded,
                onExpandedChange = onExpandedChange,
                placeholder = {
                    DefaultText(
                        text = stringResource(Res.string.search_label),
                        color = Color.Gray.copy(alpha = 0.7f)
                    )
                },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.testTag("SearchTextField") // 👈 Add this line
            )
        },
        expanded = searchExpanded,
        onExpandedChange = onExpandedChange,
    ) {
        LazyColumn {
            items(searchHistory) { item ->
                SearchHistoryItem(
                    query = item.query,
                    date = item.formattedTimeStamp,
                    onClick = {
                        onExpandedChange(false)
                        onSearchQueryChange(item.query)
                        onSearchQueryClick()
                    }
                )
            }
        }
    }
}

@Composable
fun SearchHistoryItem(
    query: String,
    date: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(resource = Res.drawable.ic_history),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(
            modifier = Modifier.weight(1f).padding(vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            DefaultText(text = query)
            DefaultText(text = date, style = MaterialTheme.typography.labelSmall)
        }

    }
    DefaultDivider()

}