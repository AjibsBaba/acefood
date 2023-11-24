package com.ajibsbaba.acefood.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.black50
import com.ajibsbaba.acefood.ui.theme.white100

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InferenceModal() {
    val sheetState = rememberModalBottomSheetState()
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    PrimaryButton(label = "Run Inference") {
        isBottomSheetVisible = true
    }

    if (isBottomSheetVisible) {
        ModalBottomSheet(
            onDismissRequest = { /*TODO*/ },
            containerColor = white100,
            sheetState = sheetState
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 28.dp)
            ) {
                Text(
                    text = "Detection Results",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = black50,
                        textAlign = TextAlign.Center
                    )
                )
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Disease Type",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight(800),
                                color = black50,
                            )
                        )
                        Text(
                            text = "Early Blight",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight(300),
                                color = black50,
                            )
                        )
                    }
                    Divider()
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Confidence Level",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight(800),
                                color = black50,
                            )
                        )
                        Text(
                            text = "65%",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight(300),
                                color = black50,
                            )
                        )
                    }
                    Divider()
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 4.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Algorithm",
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight(800),
                                color = black50,
                            )
                        )
                        Text(
                            text = "CNN",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight(300),
                                color = black50,
                            )
                        )
                    }
                    Divider()
                }
                PrimaryButton(label = "Scan Again") {
                    isBottomSheetVisible = false
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiseaseDetailsCard() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var isBottomSheetVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(top = 20.dp)
            .clickable { isBottomSheetVisible = true }, colors = CardDefaults.cardColors(
            containerColor = white100
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Explore Types of Diseases",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = axiformaFamily
                ),
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
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp, start = 24.dp, end = 24.dp, bottom = 18.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(bottom = 25.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Tomato Diseases",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight.ExtraBold,
                            color = black50,
                        )
                    )
                    Text(
                        text = "Existing classes tomato diseases on Acefood",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                            color = black50,
                        )
                    )
                }
                LazyColumn {
                    items(1) { _ ->
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
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
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
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
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
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
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
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
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
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
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
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
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
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
                        Text(
                            modifier = Modifier.padding(top = 19.dp, bottom = 19.dp),
                            text = "Leaf Mold",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = axiformaFamily,
                                fontWeight = FontWeight.Normal,
                                color = black50,
                                textAlign = TextAlign.Center,
                            )
                        )

                    }
                }
            }
        }
    }
}


@Preview()
@Composable
fun DiseaseModalPreview() {
    DiseaseDetailsCard()
}

@Preview()
@Composable
fun InferenceModalPreview() {
    InferenceModal()
}