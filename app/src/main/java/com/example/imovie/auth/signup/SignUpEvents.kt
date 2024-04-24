package com.example.imovie.auth.signup

import com.example.imovie.auth.login.LoginEvents

sealed class SignUpEvents {
    class EmailChange(val value: String): SignUpEvents()
    class PasswordChange(val value: String): SignUpEvents()
    class UsernameChange(val value: String): SignUpEvents()
    class Submit(): SignUpEvents()
}