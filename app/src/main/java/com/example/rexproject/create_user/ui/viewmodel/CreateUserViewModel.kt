package com.example.rexproject.create_user.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rexproject.core.data.local.shared_preferences.UserPreferences
import com.example.rexproject.core.domain.adapters.UserAdapter
import com.example.rexproject.create_user.data.services.CreateUserService
import com.example.rexproject.create_user.domain.dtos.CreateUserDto
import com.example.rexproject.create_user.domain.models.CreateUserState
import kotlinx.coroutines.launch

class CreateUserViewModel(app : Application) : AndroidViewModel(app) {
    private val _username = mutableStateOf("")
    val createUserState = mutableStateOf<CreateUserState>(CreateUserState.Idle)
    private val _userPreferences = UserPreferences(app)
    private val _createUserService = CreateUserService()

    fun getUsername () = _username.value

    fun setUsername (username : String) {
        _username.value = username
    }

    fun saveUsername () {
        val token = _userPreferences.getToken()
        val createUserDto = CreateUserDto(_username.value, token)

        if(createUserDto.isValid()){
            viewModelScope.launch {
                createUserState.value = CreateUserState.Loading
                val result = _createUserService.createUser(createUserDto)

                result.fold(
                    onSuccess = {
                        val userRes = UserAdapter(it.id, it.username)
                        createUserState.value = CreateUserState.Success(userRes)
                        _userPreferences.saveUserData(userRes)
                    },
                    onFailure = {
                        createUserState.value = CreateUserState.Error(it.message ?: "Error desconocido")
                    }
                )
            }
        }else{
            createUserState.value = CreateUserState.Error("Todos los campos son requeridos")
        }
    }
}