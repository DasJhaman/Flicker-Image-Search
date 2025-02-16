package com.sap.presentation.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun DefaultText(
    text: String,
    color: Color = MaterialTheme.colorScheme.onBackground,
    modifier: Modifier = Modifier,
    style: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.bodyMedium,
    textProperties: TextProperties = TextProperties()

) {
    Text(
        text = text,
        color = color,
        textAlign = textProperties.textAlign,
        modifier = modifier,
        style = style,
        maxLines = textProperties.maxLines,
        textDecoration = textProperties.textDecoration
    )
}


data class TextProperties(
    val textDecoration: TextDecoration = TextDecoration.None,
    val overflow: TextOverflow = TextOverflow.Clip,
    val maxLines: Int = Int.MAX_VALUE,
    val textAlign: TextAlign = TextAlign.Start,
)