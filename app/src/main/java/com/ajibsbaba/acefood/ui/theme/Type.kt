package com.ajibsbaba.acefood.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ajibsbaba.acefood.R


// Custom Font Family
val axiformaFamily = FontFamily(
    Font(R.font.axiforma_light, FontWeight.Light),
    Font(R.font.axiforma_regular, FontWeight.Normal),
    Font(R.font.axiforma_heavy, FontWeight.Bold),
    Font(R.font.axiforma_extrabold, FontWeight.ExtraBold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = axiformaFamily,
        fontWeight = FontWeight(250),
        fontSize = 16.sp,
    ),

    labelSmall = TextStyle(
        fontFamily = axiformaFamily,
        fontWeight = FontWeight(800),
        fontSize = 14.sp
    ),

    titleLarge = TextStyle(
        fontFamily = axiformaFamily,
        fontWeight = FontWeight(800),
        fontSize = 32.sp,
    ),
)