package com.example.imovie.auth.login

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(events: LoginEvents){
        when(events){
            is LoginEvents.EmailChange -> {
                _uiState.update {
                    it.copy(email = events.value)
                }
            }
            is LoginEvents.PasswordChange -> {
                _uiState.update {
                    it.copy(password = events.value)
                }
            }
            is LoginEvents.Submit -> {}
        }
    }
}