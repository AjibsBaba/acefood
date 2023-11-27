package com.ajibsbaba.acefood.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.red10
import com.ajibsbaba.acefood.ui.theme.red100


@Composable
fun AcefoodNav(navController: NavController = rememberNavController()) {

    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf("Home", "Profile")

    val screenIconMap = mapOf(
        items[0] to Icons.Filled.Home,
        items[1] to Icons.Filled.Person,
    )



    NavigationBar(containerColor = red10, contentColor = red100) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                label = {
                    Text(
                        item,
                        style = TextStyle(
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight.Normal
                        )
                    )
                },
                onClick = {
                    selectedItem = index
                    when (item) {
                        "Home" -> {
                            println("Navigating to Home")
                            navController.navigate(AcefoodDestinations.HOME_ROUTE)
                        }

                        "Profile" -> {
                            println("Navigating to Profile")
                            navController.navigate(AcefoodDestinations.PROFILE_ROUTE)
                        }
                    }
                },
                icon = {
                    Icon(screenIconMap[item] ?: Icons.Default.Home, contentDescription = item)
                })
        }
    }
}


@Preview
@Composable
fun NavPreview() {
    AcefoodNav()
}