package com.ajibsbaba.acefood.authentication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajibsbaba.acefood.R
import com.ajibsbaba.acefood.ui.theme.AcefoodTheme
import com.ajibsbaba.acefood.ui.theme.axiformaFamily
import com.ajibsbaba.acefood.ui.theme.black50
import com.ajibsbaba.acefood.ui.theme.red100
import com.ajibsbaba.acefood.ui.theme.white100

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AcefoodTheme {

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun LoginScreen() {
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
                    IconButton(onClick = { /* TODO */ }) {
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
                text = "Login",
                style = TextStyle(
                    fontFamily = axiformaFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp
                )
            )
            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                FormField(
                    fieldLabel = "Email Address",
                    keyboardModifier = KeyboardOptions(keyboardType = KeyboardType.Email),
                    transformation = VisualTransformation.None
                )
                FormField(
                    fieldLabel = "Password",
                    keyboardModifier = KeyboardOptions(keyboardType = KeyboardType.Password),
                    transformation = PasswordVisualTransformation()
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PrimaryButton(label = "Login", action = { /*TODO*/ })
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        text = "Did you forget your password? Reset",
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

@Composable
fun FormField(
    fieldLabel: String?,
    keyboardModifier: KeyboardOptions?,
    transformation: VisualTransformation?
) {
    var text by remember { mutableStateOf("") }
    var isValid by remember {
        mutableStateOf(false)
    }

    if (keyboardModifier != null) {
        if (transformation != null) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = {
                    text = it
                    isValid = it.isNotEmpty()
                },
                label = {
                    if (fieldLabel != null) {
                        Text(fieldLabel)
                    }
                },
                keyboardOptions = keyboardModifier,
                visualTransformation = transformation
            )
        }
    }

    if (!isValid) {
        Text(text = "Field cannot be empty", style = TextStyle(color = red100))
    }
}


@Composable
fun PrimaryButton(label: String?, action: () -> Unit) {
    Button(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        onClick = { action },
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