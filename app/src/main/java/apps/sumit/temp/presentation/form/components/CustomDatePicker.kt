package apps.sumit.temp.presentation.form.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.toSize
import apps.sumit.temp.ui.theme.primaryColor
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//@Composable
//fun DatePicker(
//    modifier: Modifier = Modifier,
//    context: Context,
//    title: String,
//) {
//
//    var pickedDate by remember {
//        mutableStateOf(LocalDate.now())
//    }
//
//    // date formatter
//    val formattedDate by remember {
//        derivedStateOf {
//            DateTimeFormatter
//                .ofPattern("dd/MM/yyyy")
//                .format(pickedDate)
//        }
//    }
//
//    // used to get dialogs
//    val dialogState = rememberMaterialDialogState()
//
//    Column(
//        modifier = modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//
//        Button(onClick = {
//            dialogState.show()
//        }) {
//            Text(text = "pick Time")
//        }
//
//        Text(text = formattedDate)
//
//    }
//
//    // customise what dialog depending upon dialogState
//    MaterialDialog(
//        dialogState = dialogState,
//        buttons = {
//            // on the accept button clicked
//            positiveButton("Ok") {
//                Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
//            }
//            // on cancel button clicked
//            negativeButton("Cancel") {
//                Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show()
//            }
//        }
//    ) {
//
//        // only use date picker from material dialog
//        this.datepicker(
//            initialDate = LocalDate.now(),
//            title = title,
//            // validate the date range
//            allowedDateValidator = {
//                it.year in 1980..2025
//            }
//        ) {
//            pickedDate = it
//        }
//
//    }
//
//}
//

@Composable
fun CustomDatePicker(
    modifier: Modifier = Modifier,
    context: Context,
    label: String,
    onTextChange: (String) -> Unit,
) {

    val icon = Icons.Filled.DateRange

    var pickedDate by remember {
        mutableStateOf(LocalDate.now())
    }

    // date formatter
    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd/MM/yyyy")
                .format(pickedDate)
        }
    }

    // used to get dialogs
    val dialogState = rememberMaterialDialogState()

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }


    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        // Create an Outlined Text Field
        // with icon and not expanded
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
            label = { Text(label) },
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
                Icon(icon, "contentDescription",
                    Modifier.clickable { dialogState.show() })
            }
        )

        // customise what dialog depending upon dialogState
        MaterialDialog(
            dialogState = dialogState,
            buttons = {
                // on the accept button clicked
                positiveButton("Ok") {
                    Toast.makeText(context, "Done", Toast.LENGTH_SHORT).show()
                }
                // on cancel button clicked
                negativeButton("Cancel") {
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_SHORT).show()
                }
            }
        ) {

            // only use date picker from material dialog
            this.datepicker(
                initialDate = LocalDate.now(),
                title = label,
                // validate the date range
                allowedDateValidator = {
                    it.year in 1980..2025
                }
            ) {
                pickedDate = it
                mSelectedText = formattedDate.toString()
            }

        }
    }

}