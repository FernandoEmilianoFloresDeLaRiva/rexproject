package com.example.rexproject.shared.data.states.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.rexproject.core.domain.adapters.UserAdapter

@Composable
fun UserProvider(content : @Composable () -> Unit){
    val userState = remember {
        mutableStateOf(UserAdapter(-1, ""))
    }

    CompositionLocalProvider(value = LocalUser provides userState) {
        content()
    }

}