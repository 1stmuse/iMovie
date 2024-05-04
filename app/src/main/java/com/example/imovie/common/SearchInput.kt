package com.example.imovie.common

import androidx.compose.foundation.background
import androidx.compose.material3.TextField
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.imovie.ui.theme.DarkPrimary
import com.example.imovie.ui.theme.PrimaryColor
import com.example.imovie.ui.theme.SecondaryColor


@Composable
fun SearchInput(
    modifier: Modifier = Modifier,
    value: String,
    isPassword: Boolean = false,
    placeholder: String,
    leadingIcon: ( @Composable () -> Unit)? = null,
    trailingIcon: ( @Composable () -> Unit)? = null,
    onChange: (String) -> Unit,

    ) {

    TextField(value = value, onValueChange = onChange,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Red),
        visualTransformation = if(isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(keyboardType = if(isPassword) KeyboardType.Password else KeyboardType.Text),
        placeholder = {
            Text(text = placeholder, color = PrimaryColor)
        },
        leadingIcon = leadingIcon,
        trailingIcon = {
                      if(trailingIcon !== null){
                          trailingIcon()
                      }else {
                          Icon(imageVector = Icons.Default.Search, contentDescription = null,
                              tint = PrimaryColor
                          )
                      }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = DarkPrimary,
            unfocusedContainerColor = DarkPrimary,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White
        ),

    )
}


@Preview(showBackground = true)
@Composable
fun SearchPrev() {
    SearchInput(value = "", onChange = {}, placeholder = "email")
}