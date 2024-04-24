package com.example.imovie.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.imovie.ui.theme.PrimaryColor


@Composable
fun AppTextInput(
    value: String,
    isPassword: Boolean = false,
    placeholder: String,
    leadingIcon: ( @Composable () -> Unit)? = null,
    trailingIcon: ( @Composable () -> Unit)? = null,
    onChange: (String) -> Unit,
) {

    OutlinedTextField(value = value, onValueChange = onChange,
        modifier = Modifier.fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = PrimaryColor,
            unfocusedBorderColor = Color.White
        ),
        visualTransformation = if(isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = if(isPassword) KeyboardType.Password else KeyboardType.Text),
        label = {
            Text(text = placeholder)
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}


@Preview(showBackground = true)
@Composable
fun AppTextPrev() {
    AppTextInput(value = "", onChange = {}, placeholder = "email")
}