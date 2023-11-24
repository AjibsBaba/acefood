package com.ajibsbaba.acefood.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.acefood.OnboardingManager
import com.ajibsbaba.acefood.screens.HomeScreen
import com.ajibsbaba.acefood.screens.OnboardingScreen
import com.ajibsbaba.acefood.screens.authentication.LoginScreen
import com.ajibsbaba.acefood.screens.authentication.RegisterScreen
import com.ajibsbaba.acefood.screens.authentication.ResetPasswordScreen

object AcefoodDestinations {
    const val HOME_ROUTE = "home"
    const val LOGIN_ROUTE = "login"
    const val REGISTER_ROUTE = "register"
    const val RESET_PASSWORD_ROUTE = "reset"
    const val ONBOARDING_ROUTE = "onboarding"
}


@Composable
fun AcefoodNavigation() {
    val navController = rememberNavController()
    val context: Context = LocalContext.current
    val isOnboardingCompleted by
    OnboardingManager.onboardingCompleted(
        context
    ).collectAsState(initial = false)


    NavHost(
        navController = navController, startDestination = if (isOnboardingCompleted)
            AcefoodDestinations.HOME_ROUTE else AcefoodDestinations.ONBOARDING_ROUTE
    ) {
        composable(AcefoodDestinations.ONBOARDING_ROUTE) {
            OnboardingScreen(navController = navController)
        }
        composable(AcefoodDestinations.HOME_ROUTE) {
            HomeScreen(navController = navController)
        }
        composable(AcefoodDestinations.LOGIN_ROUTE) {
            LoginScreen(navController = navController)
        }
        composable(AcefoodDestinations.REGISTER_ROUTE) {
            RegisterScreen(navController = navController)
        }
        composable(AcefoodDestinations.RESET_PASSWORD_ROUTE) {
            ResetPasswordScreen(navController = navController)
        }
    }
}

