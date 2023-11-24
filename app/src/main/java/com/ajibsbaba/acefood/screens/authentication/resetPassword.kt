package com.ajibsbaba.acefood.screens.authentication

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ajibsbaba.acefood.R
import com.ajibsbaba.acefood.navigation.AcefoodDestinations
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.black50
import com.ajibsbaba.acefood.utils.DynamicForm
import com.ajibsbaba.acefood.utils.FormState
import com.ajibsbaba.acefood.utils.PrimaryButton
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResetPasswordScreen(navController: NavController) {
    val auth = FirebaseAuth.getInstance()

    val formStates = remember {
        listOf(
            FormState(
                fieldLabel = "Email Address",
                keyboardModifier = KeyboardOptions(keyboardType = KeyboardType.Email)
            ),
        )
    }

    val context: Context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Image(
                        painterResource(id = R.drawable.acefood_logo_icon),
                        contentDescription = "Acefood Logo",

                        )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Go to Previous Screen"
                        )
                    }
                },
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(start = 26.dp, end = 26.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Text(
                modifier = Modifier.padding(top = 32.dp),
                text = "Reset Password",
                style = TextStyle(
                    fontFamily = axiformaFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp
                )
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.verticalScroll(
                    rememberScrollState()
                )
            ) {
                DynamicForm(formStates) { value, index ->
                    formStates[index].value = value
                }

            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PrimaryButton(label = "Send Email", action = { /*TODO*/ })
                TextButton(onClick = { navController.navigate(AcefoodDestinations.REGISTER_ROUTE) }) {
                    Text(
                        text = "Don’t have an account? Register",
                        style = TextStyle(
                            fontFamily = axiformaFamily,
                            color = black50,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        )
                    )
                }
            }

        }

    }
}

private fun sendPaswordResetEmail(
    context: Context,
    auth: FirebaseAuth,
    email: String,
    onSuccess: () -> Unit
) {
    auth.sendPasswordResetEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess.invoke()
            } else {
                Toast.makeText(
                    context,
                    "Email Failure: ${task.exception?.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
}