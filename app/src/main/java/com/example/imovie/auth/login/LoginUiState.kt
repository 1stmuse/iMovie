package com.example.imovie.auth.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val loading: Boolean = false
)
