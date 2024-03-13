package apps.sumit.temp.presentation.form.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import apps.sumit.temp.domain.models.EventData
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomBottomSheet(
    showBottomSheet: Boolean,
    eventData: MutableState<EventData>,
    onComplete: (EventData) -> Unit,
    onCancel: () -> Unit,
) {

    val sheetState = rememberModalBottomSheetState()

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                onCancel()
            },
            sheetState = sheetState
        ) {
            // Sheet content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .clip(RectangleShape)
                    .align(Alignment.CenterHorizontally)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)

                ) {

                    Text(text = "Full name : ${eventData.value.name}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Registration No. : ${eventData.value.registrationNumber}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Branch : ${eventData.value.branch}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Entered I Card")
                    AsyncImage(
                        model = eventData.value.iCard,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.5.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Email : ${eventData.value.email}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Gender : ${eventData.value.gender}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Date of Birth : ${eventData.value.dateOfBirth}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Event type : ${eventData.value.typeOfEvent}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Starting date : ${eventData.value.startDate}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Ending date : ${eventData.value.endDate}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Event location : ${eventData.value.location}")
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Entered Event proof")
                    AsyncImage(
                        model = eventData.value.eventProof,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.5.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Entered bill image")
                    AsyncImage(
                        model = eventData.value.billImage,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.5.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(text = "Entered signature")
                    AsyncImage(
                        model = eventData.value.signature,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.5.dp)
                            .clip(RoundedCornerShape(20.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            onClick = {

                                onCancel()
                            }
                        ) {
                            Text(text = "Back")
                        }

                        Button(
                            onClick = {

                                onComplete(eventData.value)
                            }
                        ) {
                            Text(text = "Done")
                        }

                    }
                }


            }
        }
    }
}