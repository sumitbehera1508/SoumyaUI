package apps.sumit.temp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import apps.sumit.temp.presentation.form.InputDetailsScreen
import apps.sumit.temp.ui.theme.TempTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TempTheme {
                // A surface container using the 'background' color from the theme
                Show()
            }
        }
    }
}

@Composable
fun Show() {
    InputDetailsScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TempTheme {
        Show()
    }
}