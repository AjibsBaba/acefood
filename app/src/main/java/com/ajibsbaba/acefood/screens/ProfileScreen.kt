package com.ajibsbaba.acefood.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ajibsbaba.acefood.navigation.AcefoodDestinations
import com.ajibsbaba.acefood.navigation.AcefoodNav
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.black50
import com.ajibsbaba.acefood.ui.theme.gray35
import com.ajibsbaba.acefood.ui.theme.red100


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController = rememberNavController()) {
    val context: Context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                "Profile",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    fontFamily = axiformaFamily
                )
            )
        })
    }, bottomBar = { AcefoodNav(navController) }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Row(modifier = Modifier.padding(bottom = 16.dp)) {
                Column {
                    Text(
                        text = "Samuel Ajibade",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight(800),
                            color = black50,

                            )
                    )
                    Text(
                        text = "hello@ajibsbaba.com",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontFamily = axiformaFamily,
                            fontWeight = FontWeight.Normal,
                            color = black50,

                            )
                    )
                }
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Column(modifier = Modifier.padding(top = 16.dp)) {
                TabMenu(title = "Account Info", description = "Your Personal Information") {
                    navController.navigate(AcefoodDestinations.ACCOUNT_ROUTE)
                }
                TabMenu(title = "Model Info", description = "Model Info, Accuracy, Type") {
                    navController.navigate(AcefoodDestinations.MODEL_ROUTE)
                }
                TabMenu(title = "App Info", description = "Developer Information & App Build") {
                }
                TabMenu(title = "Suggestions", description = "Suggest Features, Improve app") {
                    Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show()
                }
                TabMenu(title = "Delete Account", description = "Delete Account Information") {
                    Toast.makeText(context, "Coming Soon", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelScreen(navController: NavController) {
    Scaffold(containerColor = gray35, topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = gray35
            ),
            title = {
                Text(
                    "Model Info",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily
                    )
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Model Type",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "Tensorflow Lite",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Model Size",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "4mb",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Algorithm Type",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "CNN",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Image Size",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "224x224",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Accuracy",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "73%",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Format",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = ".tflite",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountInfoScreen(navController: NavController) {
    Scaffold(containerColor = gray35, topBar = {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = gray35
            ),
            title = {
                Text(
                    "Account Info",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        fontFamily = axiformaFamily
                    )
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Name",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "Samuel Ajibade",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Email Address",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "hello@ajibsbaba.com",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Verification Status",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "Verified",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 20.dp, top = 16.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Farm Name",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(800),
                        color = Color(0xFF232323),
                    )
                )
                Text(
                    text = "Ajebo Farms",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = axiformaFamily,
                        fontWeight = FontWeight(300),
                        color = Color(0xFF232323),

                        )
                )
            }
            Divider(color = Color(0xFFD9D9D9), thickness = 1.dp)
        }

    }
}


@Composable
fun TabMenu(title: String, description: String, action: () -> Unit) {
    Column(modifier = Modifier
        .padding(top = 4.dp, bottom = 18.dp)
        .fillMaxWidth()
        .clickable { action() }) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontFamily = axiformaFamily,
                fontWeight = FontWeight(800),
                color = black50,
            )
        )
        Text(
            text = description,
            style = TextStyle(
                fontSize = 12.sp,
                fontFamily = axiformaFamily,
                fontWeight = FontWeight(300),
                color = black50,

                )
        )
    }
}


@Composable
fun AlertModal(
    title: String,
    description: String,
    dialogState: Boolean = false
) {

    var openDialog by remember {
        mutableStateOf(dialogState)
    }


    if (openDialog) {
        AlertDialog(
            onDismissRequest = {
                openDialog = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text(text = "Yes", style = TextStyle(color = red100))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog = false
                    }
                ) {
                    Text(text = "No", style = TextStyle(color = black50))
                }
            },
            title = { Text(title) },
            text = { Text(description) },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Warning,
                    contentDescription = null
                )
            } // add icon
        )
    }

}


@Preview(showSystemUi = true)
@Composable
fun ProfileHomeScreen() {
    ProfileScreen(navController = rememberNavController())
}


@Preview(showSystemUi = true)
@Composable
fun ModalScreenPreview() {
    ModelScreen(navController = rememberNavController())
}

@Preview(showSystemUi = true)
@Composable
fun AccountInfoScreenPreview() {
    AccountInfoScreen(navController = rememberNavController())
}


@Preview()
@Composable
fun AlertDialogPreview() {
    AlertModal(
        title = "Account Deletion",
        description = "Are you sure you want to delete your account?",
        dialogState = true
    )
}
