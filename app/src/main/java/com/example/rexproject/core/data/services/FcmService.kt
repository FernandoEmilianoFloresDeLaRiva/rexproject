package com.example.rexproject.core.data.services

import com.example.rexproject.core.data.local.shared_preferences.UserPreferences
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FcmService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        println()
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        val userPreferences = UserPreferences(applicationContext)
        userPreferences.clearToken()
        userPreferences.saveToken(token)
    }
}