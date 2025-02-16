package com.sap.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import flickerimagesearch.composeapp.generated.resources.Res
import flickerimagesearch.composeapp.generated.resources.generic_error_cta_title
import flickerimagesearch.composeapp.generated.resources.generic_error_message
import flickerimagesearch.composeapp.generated.resources.generic_error_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun GenericError(
    title: String = stringResource(resource = Res.string.generic_error_title),
    message: String = stringResource(resource = Res.string.generic_error_message),
    onRetryClicked: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier.fillMaxSize().testTag("GenericError"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = title.uppercase(),
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary
        )

        onRetryClicked?.let {
            Spacer(modifier = Modifier.size(10.dp))
            DefaultButton(
                onClick = onRetryClicked,
                modifier = Modifier.widthIn(min = 200.dp).testTag("RetryButton"),
                text = stringResource(resource = Res.string.generic_error_cta_title)
            )
        }

    }
}

@Preview
@Composable
private fun GenericErrorPreview() {
    GenericError(onRetryClicked = {})
}
