package com.example.imovie.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.imovie.auth.login.LoginEvents
import com.example.imovie.auth.login.LoginViewModel
import com.example.imovie.components.AppButton
import com.example.imovie.components.AppTextInput
import com.example.imovie.navGraph.Destination
import com.example.imovie.ui.theme.PrimaryColor

@Composable
fun SignupScreen(navController: NavHostController) {
    val vm: SIgnUpViewModel = hiltViewModel()
    val uiState = vm.uiState.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign Up", color = Color.White, style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(20.dp))
        AppTextInput(value = uiState.email, placeholder = "Email", leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = null, tint = PrimaryColor )
        }){
            vm.onEvent(SignUpEvents.EmailChange(it))
        }
        Spacer(modifier = Modifier.height(20.dp))
        AppTextInput(value = uiState.username, placeholder = "Username", leadingIcon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = null, tint = PrimaryColor )
        }) {
            vm.onEvent(SignUpEvents.UsernameChange(it))
        }
        Spacer(modifier = Modifier.height(20.dp))
        AppTextInput(value = uiState.password, placeholder = "Password", leadingIcon = {
            Icon(imageVector = Icons.Default.Lock, contentDescription = null, tint = PrimaryColor )
        }, isPassword = true) {
            vm.onEvent(SignUpEvents.PasswordChange(it))
        }
        Spacer(modifier = Modifier.height(20.dp))
        AppButton(label = "Create Account") {
            navController.popBackStack()
            navController.navigate(Destination.Login.route)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = buildAnnotatedString {
            append("Already have an account ?")
            withStyle(
               SpanStyle(
                   color = Color.Magenta
               )
            ){
                append("Login")
            }
        }, modifier = Modifier.clickable {
            navController.navigate(Destination.Login.route)
        }, color = Color.White)
    }
}