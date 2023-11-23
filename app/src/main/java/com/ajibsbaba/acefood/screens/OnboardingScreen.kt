package com.ajibsbaba.acefood.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ajibsbaba.acefood.OnboardingManager
import com.ajibsbaba.acefood.R
import com.ajibsbaba.acefood.screens.authentication.PrimaryButton
import com.ajibsbaba.acefood.navigation.AcefoodDestinations
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.black50


@Composable
fun OnboardingScreen(navController: NavController) {
    val context = LocalContext.current

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 26.dp, end = 26.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(id = R.drawable.onboarding_vector),
                contentDescription = "Onboarding Vector",
                modifier = Modifier.padding(40.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text(
                    text = "Scan & Detect.",
                    style = TextStyle(
                        fontSize = 32.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = black50,
                    )
                )
                Text(
                    text = "With a modern android architecture and  Artificial intelligence detect diseases in tomato plants for free",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight.Light,
                        color = black50,
                        textAlign = TextAlign.Center,
                        lineHeight = 24.sp
                    )
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 64.dp)
            ) {
                PrimaryButton(label = "Get Started") {
                    OnboardingManager.setOnboardingCompleted(context)
                    navController.navigate(AcefoodDestinations.HOME_ROUTE)
                }
                TextButton(
                    onClick = {
                        navController.navigate(AcefoodDestinations.LOGIN_ROUTE)
                    },
                    modifier = Modifier.padding(top = 2.dp),

                    ) {
                    Text(
                        text = "Already have an account? Login",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight(300),
                            color = black50,
                        )
                    )
                }
            }
        }
    }
}