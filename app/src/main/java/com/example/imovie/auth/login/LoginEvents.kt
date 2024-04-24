package com.example.imovie.auth.login

sealed class LoginEvents {

    class EmailChange(val value: String): LoginEvents()
    class PasswordChange(val value: String): LoginEvents()
    class Submit(): LoginEvents()
}