package com.sap.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import flickerimagesearch.composeapp.generated.resources.Res
import flickerimagesearch.composeapp.generated.resources.generic_empty_cta_title
import flickerimagesearch.composeapp.generated.resources.generic_empty_message
import flickerimagesearch.composeapp.generated.resources.generic_empty_title
import flickerimagesearch.composeapp.generated.resources.generic_error_cta_title
import flickerimagesearch.composeapp.generated.resources.generic_error_message
import flickerimagesearch.composeapp.generated.resources.generic_error_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun GenericEmptyView(
    modifier: Modifier = Modifier,
    title: String = stringResource(resource = Res.string.generic_empty_title),
    message: String = stringResource(resource = Res.string.generic_empty_message),
    onSearchClicked: (() -> Unit)? = null
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Placeholder Illustration or Icon
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .padding(bottom = 16.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        // Title
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )

        // Message
        Text(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )

        // Search Button (Optional)
        onSearchClicked?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onSearchClicked,
                modifier = Modifier.widthIn(min = 200.dp)
            ) {
                Text(text = stringResource(resource = Res.string.generic_empty_cta_title))
            }
        }
    }
}

@Preview
@Composable
private fun GenericEmptyViewPreview() {
    GenericEmptyView()
}
