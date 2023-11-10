package com.ajibsbaba.acefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajibsbaba.acefood.ui.theme.AcefoodTheme
import com.ajibsbaba.acefood.ui.theme.Typography
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.black50
import com.ajibsbaba.acefood.ui.theme.gray35
import com.ajibsbaba.acefood.ui.theme.red100
import com.ajibsbaba.acefood.ui.theme.white100
import com.ajibsbaba.acefood.ui.theme.white50

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
        containerColor = gray35,
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
        containerColor = gray35
        ),
                title = {
                    Image(painterResource(id = R.drawable.acefood_logo), contentDescription = "Acefood Logo", modifier = Modifier.width(94.dp))
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
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .clickable { }, colors = CardDefaults.cardColors(
        containerColor = red100
    )) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(start = 16.dp)) {
            Icon(tint = red100, imageVector = Icons.Outlined.Search, contentDescription = "Search Icon", modifier = Modifier
                .padding(end = 14.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(
                    white100
                )
                .padding(5.dp))
            Column {
                Text(text = "Start a disease scan",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Bold,
                        color = white50,

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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiseaseDetailsCard() {
    val sheetState = rememberModalBottomSheetState()
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .padding(top = 20.dp)
        .clickable { isBottomSheetVisible = true }, colors = CardDefaults.cardColors(
            containerColor = white100
        )) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Explore Types of Diseases",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily),
                        fontWeight = FontWeight.ExtraBold,
                        color = black50,
                    )
            }
    }
    
    if (isBottomSheetVisible) {
        ModalBottomSheet(
            containerColor = white100,
            windowInsets = BottomSheetDefaults.windowInsets,
            onDismissRequest = {
                isBottomSheetVisible = false
                               },
            sheetState = sheetState) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, start = 24.dp, end = 24.dp)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .padding(bottom = 25.dp)
                    .fillMaxWidth()) {
                    Text(
                        text = "Tomato Disease Classes",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight.ExtraBold,
                            color = black50,
                        )
                    )
                    Text(
                        text = "Types of tomato diseases that can be detected with this app",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight.Normal,
                            color = black50,
                        )
                    )
                }
                LazyColumn {
                    items(1) {_ ->
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Mosaic Virus",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Divider()
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Early Blight",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Divider()
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Septoria Leaf Spot",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Divider()
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Bacterial Spot",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Divider()
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Target Spot",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Divider()
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Spider Mites",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Divider()
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Yellow Leaf Curl Virus",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        Divider()
                        Text(modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Leaf Mold",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )
                        TextButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(top = 35.dp, bottom = 35.dp)) {
                            Text(
                                text = "Close",
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = axiformaFamily,
                                    fontWeight = FontWeight.Normal,
                                    color = black50,
                                )
                            )
                        }
                    }
                }
            } }
        }
    }


@Composable
fun RecentScansCard() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 30.dp)) {
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
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                white100
            )
            .padding(16.dp) ) {
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
        Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(
                white100
            )
            .padding(16.dp) ) {
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


@Composable
fun PlantDiseaseList() {

}
@Preview(showBackground = true)
@Composable
fun RecentScansPreview() {
    AcefoodTheme {
        RecentScansCard()
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    AcefoodTheme {
        ScanButton(onClick = {})
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AcefoodTheme {
        HomeScreen()
    }
}