package com.example.imovie.auth.signup

import androidx.lifecycle.ViewModel
import com.example.imovie.auth.login.LoginEvents
import com.example.imovie.auth.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class SIgnUpViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState = _uiState.asStateFlow()

    fun onEvent(events: SignUpEvents){
        when(events){
            is SignUpEvents.EmailChange -> {
                _uiState.update {
                    it.copy(email = events.value)
                }
            }
            is SignUpEvents.PasswordChange -> {
                _uiState.update {
                    it.copy(password = events.value)
                }
            }
            is SignUpEvents.UsernameChange -> {
                _uiState.update {
                    it.copy(username = events.value)
                }
            }
            is SignUpEvents.Submit -> {}


        }
    }
}