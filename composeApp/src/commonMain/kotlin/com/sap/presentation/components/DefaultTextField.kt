
package com.sap.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.sap.presentation.theme.textFieldErrorStyle
import com.sap.presentation.theme.textFieldPlaceholderStyle
import com.sap.presentation.theme.textFieldStyle

@Composable
fun DefaultTextField(
    modifier: Modifier = Modifier,
    labelTitle: String? = null,
    value: String,
    onValueChange: (String) -> Unit = {},
    textFieldConfig: TextFieldConfig = TextFieldConfig(),
    errorConfig: ErrorConfig = ErrorConfig(),
    focusedContainerColor: Color = Color.Unspecified,
    unfocusedContainerColor: Color = Color.Unspecified,
    focusedTextColor: Color = Color.Unspecified,
    textStyle: TextStyle = textFieldStyle(),
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        enabled = textFieldConfig.enabled,
        isError = errorConfig.isError,
        minLines = textFieldConfig.minLines,
        maxLines = textFieldConfig.maxLines,
        singleLine = textFieldConfig.isSingleLine,
        trailingIcon = textFieldConfig.trailingIcon,
        leadingIcon = textFieldConfig.leadingIcon,
        keyboardOptions = textFieldConfig.keyboardOptions,
        keyboardActions = textFieldConfig.keyboardActions,
        visualTransformation = textFieldConfig.visualTransformation,
        textStyle = textStyle,
        modifier = modifier.padding(top = 4.dp),
        placeholder = textFieldConfig.placeHolder,
        label = {
            labelTitle?.let {
                Text(
                    text = labelTitle,
                    style = textFieldPlaceholderStyle(),
                    maxLines = 1
                )
            }

        },
        supportingText = {
            if ((errorConfig.isError || errorConfig.forceErrorTitle) && errorConfig.errorTitle != null) {
                Text(
                    text = errorConfig.errorTitle,
                    style = textFieldErrorStyle(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        shape = MaterialTheme.shapes.medium,
        colors = when {
            textFieldConfig.overrideDisabledColors -> OutlinedTextFieldDefaults.colors(
                disabledBorderColor = MaterialTheme.colorScheme.outline,
                disabledLabelColor = MaterialTheme.colorScheme.tertiary,
                disabledTextColor = LocalContentColor.current,
            )

            else -> OutlinedTextFieldDefaults.colors(
                focusedContainerColor = focusedContainerColor,
                unfocusedContainerColor = unfocusedContainerColor,
                focusedTextColor = focusedTextColor
            )
        }
    )
}

data class TextFieldConfig(
    val enabled: Boolean = true,
    val overrideDisabledColors: Boolean = false,
    val isSingleLine: Boolean = true,
    val forceErrorTitle: Boolean = false,
    val minLines: Int = 1,
    val maxLines: Int = Int.MAX_VALUE,
    val visualTransformation: VisualTransformation = VisualTransformation.None,
    val trailingIcon: @Composable (() -> Unit)? = null,
    val leadingIcon: @Composable (() -> Unit)? = null,
    val placeHolder: @Composable (() -> Unit)? = null,
    val keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    val keyboardActions: KeyboardActions = KeyboardActions.Default
)

data class ErrorConfig(
    val errorTitle: String? = null,
    val forceErrorTitle: Boolean = false,
    val isError: Boolean = false,
)