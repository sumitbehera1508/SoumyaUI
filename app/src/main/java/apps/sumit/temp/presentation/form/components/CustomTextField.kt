package apps.sumit.temp.presentation.form.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import apps.sumit.temp.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    text: String,
    onTextChange: (String) -> Unit,
    onTrailingIconClick: () -> Unit,
    hints: String,
    imageVectorTrailing: Painter? = null,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier,
    imeAction: ImeAction = ImeAction.Done,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    isError: Boolean = false,
    errorMessage: String = "",
    maxDigit: Int,
    isReadable: Boolean = false,
    isEnable: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {

    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }


    Column(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = {
                mSelectedText = it
                onTextChange(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text(hints) },
            isError = isError,
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                // cursorColor = if (mSelectedText.isEmpty()) fingerGrey else primaryColor,
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = primaryColor,
//                disabledBorderColor = if (mSelectedText.isEmpty()) fingerGrey else primaryColor,
//                focusedLabelColor = if (mSelectedText.isEmpty()) fingerGrey else primaryColor,
            ),
            trailingIcon = {
                imageVectorTrailing?.let {
                    Image(
                        painter = it,
                        contentDescription = "",
                        modifier = Modifier.clickable {
                            onTrailingIconClick.invoke()
                        })
                }
            },

            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
            keyboardActions = keyboardActions,
            enabled = isEnable,
            readOnly = isReadable,
            maxLines = 1,
            visualTransformation = visualTransformation
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}