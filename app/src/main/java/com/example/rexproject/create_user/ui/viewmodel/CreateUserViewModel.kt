package com.example.rexproject.create_user.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import com.example.rexproject.core.data.local.shared_preferences.UserPreferences
import com.example.rexproject.core.domain.adapters.UserAdapter

class CreateUserViewModel(app : Application) : AndroidViewModel(app) {
    val _username = mutableStateOf("")
    val userPreferences = UserPreferences(app)

    fun getUsername () = _username.value

    fun setUsername (username : String) {
        _username.value = username
    }

    fun saveUsername () {
        // petición al back
        val userRes = UserAdapter(1, "fer")
        userPreferences.saveUserData(userRes)
    }
}