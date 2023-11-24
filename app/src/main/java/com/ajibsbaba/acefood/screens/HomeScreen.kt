package com.ajibsbaba.acefood.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ajibsbaba.acefood.R
import com.ajibsbaba.acefood.ui.theme.Typography
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.black50
import com.ajibsbaba.acefood.ui.theme.gray35
import com.ajibsbaba.acefood.ui.theme.white100
import com.ajibsbaba.acefood.utils.DiseaseDetailsCard
import com.ajibsbaba.acefood.utils.ScanButton

@Composable
fun RecentScansCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)
    ) {
        Text(
            text = "Recent Scans",
            modifier = Modifier.padding(bottom = 16.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = axiformaFamily,
                fontWeight = FontWeight.ExtraBold,
                color = black50,
            )
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(
                    white100
                )
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "Tomato",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.ExtraBold,
                        color = black50,

                        )
                )
                Text(
                    text = "Late Blight",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Normal,
                        color = black50,

                        )
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "73%",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Normal,
                        color = black50,

                        )
                )
                Text(
                    text = "Accuracy",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Normal,
                        color = black50,

                        )
                )
            }
        }
        Row(modifier = Modifier.height(12.dp)) {

        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(
                    white100
                )
                .padding(16.dp)
        ) {
            Column {
                Text(
                    text = "Tomato",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.ExtraBold,
                        color = black50,

                        )
                )
                Text(
                    text = "Late Blight",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Normal,
                        color = black50,

                        )
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "73%",
                    style = TextStyle(
                        fontSize = 13.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Normal,
                        color = black50,

                        )
                )
                Text(
                    text = "Accuracy",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Normal,
                        color = black50,

                        )
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        containerColor = gray35,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = gray35
                ),
                title = {
                    Image(
                        painterResource(id = R.drawable.acefood_logo),
                        contentDescription = "Acefood Logo",
                        modifier = Modifier.width(94.dp)
                    )
                }
            )
        },
        bottomBar = {}
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                UserCard()
                ScanButton {
                }
                DiseaseDetailsCard()
            }


            RecentScansCard()
        }
    }
}


@Composable
fun UserCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Column {
            Text("Hello\nSamuel", style = Typography.titleLarge, color = Color.Black)
            Text("hello@ajibsbaba.com", style = Typography.labelSmall, color = Color.Black)
        }
    }
}
