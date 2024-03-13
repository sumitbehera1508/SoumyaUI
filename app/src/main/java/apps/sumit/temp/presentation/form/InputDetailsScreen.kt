package apps.sumit.temp.presentation.form

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import apps.sumit.temp.domain.models.EventData
import apps.sumit.temp.presentation.form.components.CustomBottomSheet
import apps.sumit.temp.presentation.form.components.CustomDatePicker
import apps.sumit.temp.presentation.form.components.CustomDropDownList
import apps.sumit.temp.presentation.form.components.CustomFileChooser
import apps.sumit.temp.presentation.form.components.CustomTextField
import apps.sumit.temp.ui.theme.fingerGrey
import apps.sumit.temp.ui.theme.primaryColor
import apps.sumit.temp.util.DropDownData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDetailsScreen(
    modifier: Modifier = Modifier
        .fillMaxSize(),
) {
    val context = LocalContext.current
    val eventData = remember {
        mutableStateOf(EventData())
    }

    var bottomSheetShow by remember {
        mutableStateOf(false)
    }

    var isActive by remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = modifier
            .background(Color.Transparent),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Enter your details")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = primaryColor
                        )
                    ) {
                        Text(text = "b1")
                    }
                    Button(
                        onClick = {
                            bottomSheetShow = true
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isActive) primaryColor else fingerGrey
                        )
                    ) {
                        Text(text = "b2")
                    }
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
                .verticalScroll(rememberScrollState())
        ) {
            CustomTextField(
                text = "John Doe",
                onTextChange = { text ->
                    eventData.value.name = text
                    isActive = eventData.value.isComplete()
                },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter your full name",
                keyboardType = KeyboardType.Text,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            )

            CustomTextField(
                text = "11111111",
                onTextChange = { text ->
                    eventData.value.registrationNumber = text
                    isActive = eventData.value.isComplete()
                },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter your registration no",
                keyboardType = KeyboardType.Number,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )

            CustomDropDownList(
                label = "Select your branch",
                onTextChange = { text ->
                    eventData.value.branch = text
                    isActive = eventData.value.isComplete()
                },
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                options = DropDownData().branchList
            )

            CustomFileChooser(
                onUriDetect = { uri ->
                    eventData.value.iCard = uri
                    isActive = eventData.value.isComplete()
                },
                label = "Enter I card",
                successMessage = "Done",
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                showImage = true
            )

            CustomTextField(
                text = "johndoe@email.com",
                onTextChange = { text ->
                    eventData.value.email = text
                    isActive = eventData.value.isComplete()
                },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter your email",
                keyboardType = KeyboardType.Email,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )

            CustomDropDownList(
                label = "Select your gender",
                onTextChange = { text ->
                    eventData.value.gender = text
                    isActive = eventData.value.isComplete()
                },
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                options = DropDownData().genderList
            )

            CustomDatePicker(
                context = context,
                label = "Enter your date of birth",
                onTextChange = { text ->
                    eventData.value.dateOfBirth = text
                    isActive = eventData.value.isComplete()
                },
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                successMessage = "Date of birth added !"
            )

            CustomDropDownList(
                label = "Enter type of event",
                onTextChange = { text ->
                    eventData.value.typeOfEvent = text
                    isActive = eventData.value.isComplete()
                },
                options = DropDownData().eventTypeList,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            )

            CustomDatePicker(
                context = context,
                label = "Enter Starting date",
                onTextChange = { text ->
                    eventData.value.startDate = text
                    isActive = eventData.value.isComplete()
                },
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                successMessage = "Starting date added !"
            )

            CustomDatePicker(
                context = context,
                label = "Enter Ending date",
                onTextChange = { text ->
                    eventData.value.endDate = text
                    isActive = eventData.value.isComplete()
                },
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                successMessage = "Ending date added !"
            )

            CustomTextField(
                text = "Bhubaneswar",
                onTextChange = { text ->
                    eventData.value.location = text
                    isActive = eventData.value.isComplete()
                },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter the location of event",
                keyboardType = KeyboardType.Text,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )

            CustomFileChooser(
                onUriDetect = { uri ->
                    eventData.value.eventProof = uri
                    isActive = eventData.value.isComplete()
                },
                label = "Enter proof of event",
                successMessage = "Proof of event added Successfully",
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                showImage = true
            )

            CustomFileChooser(
                onUriDetect = { uri ->
                    eventData.value.billImage = uri
                    isActive = eventData.value.isComplete()
                },
                label = "Enter bill images",
                successMessage = "Bill images added Successfully",
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                showImage = true
            )

            CustomFileChooser(
                onUriDetect = { uri ->
                    eventData.value.signature = uri
                    isActive = eventData.value.isComplete()
                },
                label = "Enter your signature",
                successMessage = "Signature added Successfully",
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                showImage = true
            )
        }
        CustomBottomSheet(
            showBottomSheet = bottomSheetShow,
            eventData = eventData,
            onComplete = {
                bottomSheetShow = false
                Toast.makeText(context, "Details Added Successfully", Toast.LENGTH_SHORT).show()
            },
            onCancel = {
                bottomSheetShow = false
                Toast.makeText(context, "Details not added", Toast.LENGTH_SHORT).show()
            }
        )
    }
}