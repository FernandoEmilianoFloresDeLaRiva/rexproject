package com.example.rexproject.shared.data.states.user

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf
import com.example.rexproject.core.domain.adapters.UserAdapter

val LocalUser = compositionLocalOf<MutableState<UserAdapter>>{
    error("No User found in CompositionLocal")
}

fun MutableState<UserAdapter>.setUser(user: UserAdapter){
    this.value = user
}

fun MutableState<UserAdapter>.getUser(): UserAdapter = this.value