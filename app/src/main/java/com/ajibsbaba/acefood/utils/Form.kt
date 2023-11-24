package com.ajibsbaba.acefood.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.ajibsbaba.acefood.ui.theme.red100


data class FormState(
    var value: String = "",
    var isValid: Boolean = false,
    val fieldLabel: String? = null,
    val keyboardModifier: KeyboardOptions? = KeyboardOptions.Default,
    val transformation: VisualTransformation? = VisualTransformation.None,
    val errorMessage: String? = null
)

@Composable
fun FormField(
    formState: FormState,
    onValueChange: (String) -> Unit

) {
    formState.transformation?.let {
        formState.keyboardModifier?.let { it1 ->
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = formState.value,
                onValueChange = {
                    onValueChange(it)
                    formState.value = it
                },
                label = {
                    formState.fieldLabel?.let { Text(it) }
                },
                keyboardOptions = it1,
                visualTransformation = it
            )
        }
    }

    if (!formState.isValid) {
        Text(
            text = formState.errorMessage ?: "Field cannot be empty",
            style = TextStyle(color = red100)
        )
    }
}

@Composable
fun DynamicForm(formStates: List<FormState>, onValueChange: (String, Int) -> Unit) {
    Column {
        formStates.forEachIndexed { index, formState ->
            FormField(formState) {
                onValueChange(it, index)
            }
        }
    }
}