package com.ajibsbaba.acefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.acefood.navigation.AcefoodNavigation
import com.ajibsbaba.acefood.ui.theme.AcefoodTheme
import com.ajibsbaba.acefood.ui.theme.white100

class AcefoodApplication : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcefoodTheme {
                AcefoodApp()
            }
        }
    }
}


@Composable
fun AcefoodApp() {
    val navController: NavController = rememberNavController()
    AcefoodTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = white100) {
            AcefoodNavigation(navController)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    AcefoodApp()
}