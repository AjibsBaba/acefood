package com.ajibsbaba.acefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajibsbaba.acefood.ui.theme.AcefoodTheme
import com.ajibsbaba.acefood.ui.theme.Typography
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.red100
import com.ajibsbaba.acefood.ui.theme.white100

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcefoodTheme {
                HomeScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Image(painterResource(id = R.drawable.acefood_logo), contentDescription = "Acefood Logo", modifier = Modifier.width(94.dp))
                }
            )
        },
        ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding) .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            UserCard()
            ScanButton {
            }
            }
        }
    }


@Composable
fun UserCard() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp)) {
        Column {
            Text("Hello\nSamuel", style = Typography.titleLarge, color = Color.Black)
            Text("hello@ajibsbaba.com", style = Typography.labelSmall, color = Color.Black)
        }
    }
}

@Composable
fun ScanButton(onClick: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center,modifier = Modifier
        .background(red100)
        .fillMaxWidth()
        .padding(start = 16.dp)
        .height(70.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            Icon(tint = red100, imageVector = Icons.Outlined.Search, contentDescription = "Search Icon", modifier = Modifier.padding(end = 14.dp) .background(
                white100) .padding(4.dp))
            Column {
                Text(text = "Start a disease scan",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFF6F6F6),

                        )
                )
                Text(
                    text = "Save your plants today!",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Normal,
                        color = white100,

                        )
                )
            }
        }
    }
}


@Preview(showBackground = true, )
@Composable
fun CardPreview() {
    AcefoodTheme {
        UserCard()
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    AcefoodTheme {
        ScanButton(onClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    AcefoodTheme {
        HomeScreen()
    }
}