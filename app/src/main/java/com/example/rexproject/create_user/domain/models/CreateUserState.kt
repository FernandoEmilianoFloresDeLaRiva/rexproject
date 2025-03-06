package com.example.rexproject.create_user.domain.models

import com.example.rexproject.core.domain.adapters.UserAdapter

sealed class CreateUserState {
    data object Idle : CreateUserState()
    data object Loading : CreateUserState()
    data class Success(val user: UserAdapter) : CreateUserState()
    data class Error(val message: String) : CreateUserState()
}