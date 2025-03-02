package com.example.rexproject.core.data.local.shared_preferences

import android.content.Context
import com.example.rexproject.core.domain.adapters.UserAdapter
import com.example.rexproject.core.domain.constants.SharedPreferencesConstants

class UserPreferences(ctx : Context) {
    private val sharedPreferences = ctx.getSharedPreferences(SharedPreferencesConstants.PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun saveUserData(userData : UserAdapter){
        val editor = sharedPreferences.edit()
        editor.putInt((SharedPreferencesConstants.USER_ID_PREFERENCE), userData.id)
        editor.putString(SharedPreferencesConstants.USER_NAME_PREFERENCE, userData.username)
        editor.apply()
    }

    fun getUserData() : UserAdapter {
        val id = sharedPreferences.getInt(SharedPreferencesConstants.USER_ID_PREFERENCE, -1)
        val username = sharedPreferences.getString(SharedPreferencesConstants.USER_NAME_PREFERENCE, null)
        return UserAdapter(id, username ?: "")
    }

    fun clearUserData(){
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}