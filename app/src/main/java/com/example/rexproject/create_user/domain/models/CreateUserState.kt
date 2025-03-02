package com.example.rexproject.create_user.domain.models

sealed class CreateUserState {
    data object Idle : CreateUserState()
    data object Loading : CreateUserState()
    data class Success(val username: String) : CreateUserState()
    data class Error(val message: String) : CreateUserState()
}