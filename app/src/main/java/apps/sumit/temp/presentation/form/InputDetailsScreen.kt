package apps.sumit.temp.presentation.form

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import apps.sumit.temp.presentation.form.components.CustomDropDownList
import apps.sumit.temp.presentation.form.components.CustomTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputDetailsScreen(
    modifier: Modifier = Modifier
        .fillMaxSize(),
) {
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
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "b1")
                    }
                    Button(onClick = { /*TODO*/ }) {
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
                onTextChange = {/*TODO*/ },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter your full name",
                keyboardType = KeyboardType.Text,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )

            CustomTextField(
                text = "11111111",
                onTextChange = {/*TODO*/ },
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
                label = "Branch",
                onTextChange = {/*TODO*/ },
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                options = listOf("Mca", "Bca")
            )
            CustomTextField(
                text = "johndoe@email.com",
                onTextChange = {/*TODO*/ },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter your email",
                keyboardType = KeyboardType.Email,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )
            CustomTextField(
                text = "John Doe",
                onTextChange = {/*TODO*/ },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter your full name",
                keyboardType = KeyboardType.Text,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )
            CustomTextField(
                text = "John Doe",
                onTextChange = {/*TODO*/ },
                onTrailingIconClick = { /*TODO*/ },
                hints = "Enter your full name",
                keyboardType = KeyboardType.Text,
                maxDigit = 20,
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            )
        }
    }
}