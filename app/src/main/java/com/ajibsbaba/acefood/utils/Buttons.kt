package com.ajibsbaba.acefood.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.red100
import com.ajibsbaba.acefood.ui.theme.white100
import com.ajibsbaba.acefood.ui.theme.white50

@Composable
fun PrimaryButton(label: String?, action: () -> Unit) {
    Button(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        onClick = { action() },
        colors = ButtonDefaults.buttonColors(containerColor = red100, contentColor = white100)
    ) {
        if (label != null) {
            Text(
                label,
                style = TextStyle(fontFamily = axiformaFamily, fontWeight = FontWeight.ExtraBold)
            )
        }
    }
}

@Composable
fun ScanButton(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable { }, colors = CardDefaults.cardColors(
            containerColor = red100
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(start = 16.dp)
        ) {
            Icon(
                tint = red100,
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .padding(end = 14.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(
                        white100
                    )
                    .padding(5.dp)
            )
            Column {
                Text(
                    text = "Start a disease scan",
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