package com.ajibsbaba.acefood.utils

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.red100
import com.ajibsbaba.acefood.ui.theme.white100

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