package com.example.kotlinmultiplatform.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.BlurEffect // Import for blur
import com.example.kotlinmultiplatform.Greeting // Assuming Greeting class exists

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App() // Call the App function here to display course list
                }
            }
        }
    }
}

// ✅ Fixed: Correct function name and usage
fun getCourses(): List<String> {
    return listOf("Kotlin", "Jetpack Compose", "MVVM") // Example course list
}

@Composable
fun App() {
    val courses = Greeting().greet() // ✅ Fetch the list of courses

    Column(modifier = Modifier.padding(12.dp)) {
        courses.forEach { course ->
            Text(
                text = course,
                modifier = Modifier
                    .padding(vertical = 4.dp) // Padding between items
                    .graphicsLayer { // ✅ Corrected blur effect
                        renderEffect = BlurEffect(1f, 1f)

                },
                fontWeight = FontWeight.Bold // Make text bold
            )
        }
    }
}

// ✅ Fixed: Corrected Preview function
@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        App() // ✅ Corrected to call `App()`, not `GreetingView`
    }
}
