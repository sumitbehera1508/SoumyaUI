package apps.sumit.temp.presentation.form.components

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import apps.sumit.temp.R
import coil.compose.AsyncImage

//
//@Composable
//fun SinglePhotoPicker() {
//    var uri by remember {
//        mutableStateOf<Uri?>(null)
//    }
//
//    val singlePhotoPicker = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.PickVisualMedia(),
//        onResult = {
//            uri = it
//        }
//    )
//
//    val context = LocalContext.current
//
//
//    Column {
//        Button(onClick = {
//            singlePhotoPicker.launch(
//                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
//            )
//
//        }) {
//            Text("Pick Single Image")
//        }
//
//        AsyncImage(model = uri, contentDescription = null, modifier = Modifier.size(248.dp))
//
//        Button(onClick = {
//            uri?.let {
//                StorageUtil.uploadToStorage(uri = it, context = context, type = "image")
//            }
//
//        }) {
//            Text("Upload")
//        }
//
//    }
//}

//@Composable
//fun CustomFileChooser(
//    modifier: Modifier = Modifier,
//    onUriDetect: (Uri) -> Unit,
//    label: String,
//    successMessage: String = "Done",
//) {
//    val context = LocalContext.current
//
//    var uri by remember {
//        mutableStateOf<Uri?>(null)
//    }
//
//    // Create a string value to store the selected city
//    var mSelectedText by remember { mutableStateOf("") }
//
//    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
//
//    // Up Icon when expanded and down icon when collapsed
//    val icon = painterResource(id = R.drawable.baseline_upload_file_24)
//
//
//    // gets the launcher activity result
//    val singlePhotoPicker = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.PickVisualMedia(),
//        onResult = {
//            uri = it
//            if (it != null) {
//                onUriDetect(it)
//                mSelectedText = getAbsolutePathFromUri(context, it).toString()
//                Toast.makeText(context, successMessage, Toast.LENGTH_SHORT).show()
//            }
//        }
//    )
//
//
//    Column(
//        modifier = modifier.fillMaxWidth()
//    ) {
//
//        // Create an Outlined Text Field
//        // with icon and not expanded
//        OutlinedTextField(
//            value = mSelectedText,
//            onValueChange = {
//                mSelectedText = it
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .onGloballyPositioned { coordinates ->
//                    // This value is used to assign to
//                    // the DropDown the same width
//                    mTextFieldSize = coordinates.size.toSize()
//                },
//            label = { Text(label) },
//            colors = OutlinedTextFieldDefaults.colors(
//                focusedContainerColor = Color.White,
//                unfocusedContainerColor = Color.White,
//                disabledContainerColor = Color.White,
//                // cursorColor = if (mSelectedText.isEmpty()) fingerGrey else primaryColor,
//                focusedBorderColor = primaryColor,
//                unfocusedBorderColor = primaryColor,
////                disabledBorderColor = if (mSelectedText.isEmpty()) fingerGrey else primaryColor,
////                focusedLabelColor = if (mSelectedText.isEmpty()) fingerGrey else primaryColor,
//            ),
//            readOnly = true,
//            trailingIcon = {
//                Icon(
//                    painter = icon,
//                    contentDescription = "contentDescription",
//                    modifier = Modifier.clickable {
//                        singlePhotoPicker.launch(
//                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
//                        )
//                    }
//                )
//            }
//        )
//
//        if (uri != null) {
//            AsyncImage(
//                model = uri,
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.CenterHorizontally)
//            )
//        }
//    }
//
//}

@Composable
fun CustomFileChooser(
    modifier: Modifier = Modifier,
    onUriDetect: (Uri) -> Unit,
    label: String,
    showImage: Boolean = false,
    successMessage: String = "Done",
) {
    val context = LocalContext.current

    var uri by remember {
        mutableStateOf<Uri?>(null)
    }

    // Up Icon when expanded and down icon when collapsed
    val icon = painterResource(id = R.drawable.baseline_upload_file_24)


    // gets the launcher activity result
    val singlePhotoPicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            uri = it
            if (it != null) {
                onUriDetect(it)
                Toast.makeText(context, successMessage, Toast.LENGTH_SHORT).show()
            }
        }
    )


    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        // Create an Button WIth Image and Text Field

        ElevatedButton(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.height(50.dp),
            onClick = {
                singlePhotoPicker.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = label)
                Icon(painter = icon, contentDescription = "")
            }

        }

        if (showImage && uri != null) {
            AsyncImage(
                model = uri,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.5.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
    }
}