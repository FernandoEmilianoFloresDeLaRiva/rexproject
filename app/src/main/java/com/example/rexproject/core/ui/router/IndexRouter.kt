package com.example.rexproject.core.ui.router

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.rexproject.core.data.local.shared_preferences.UserPreferences
import com.example.rexproject.create_user.ui.view.CreateUserView
import com.example.rexproject.home.ui.view.HomeView
import com.example.rexproject.shared.data.states.user.LocalUser
import com.example.rexproject.shared.data.states.user.getUser
import com.example.rexproject.shared.data.states.user.setUser

@Composable
fun IndexRouter(ctx : Context, modifier: Modifier = Modifier) {
    val userPreferences = remember { UserPreferences(ctx) }
    val userFromPreferences = userPreferences.getUserData()
    val localUser = LocalUser.current

    if (userFromPreferences.id != -1 && userFromPreferences.username != "") {
        localUser.setUser(userFromPreferences)
        HomeView(username = localUser.getUser().username)
    }else{
        CreateUserView()
    }
}