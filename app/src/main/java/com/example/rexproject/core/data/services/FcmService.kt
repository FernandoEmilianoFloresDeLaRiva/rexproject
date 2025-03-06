package com.example.rexproject.core.data.services

import android.app.NotificationManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.example.rexproject.MyApp
import com.example.rexproject.R
import com.example.rexproject.core.data.local.shared_preferences.UserPreferences
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FcmService : FirebaseMessagingService() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.d("FCM_TAG", "onMessageReceived: ${message.data}")
        showNotification(message)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        val userPreferences = UserPreferences(applicationContext)
        userPreferences.clearToken()
        userPreferences.saveToken(token)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun showNotification(message: RemoteMessage) {
        val notificationManager = getSystemService(NotificationManager::class.java)
        val title = message.data["title"] ?: ""
        val body = message.data["body"] ?: ""
        val notification = NotificationCompat.Builder(this, MyApp.NOTIFICATION_CHANNEL_ID)
            .setContentTitle(title)
            .setContentText(body)
            .setSmallIcon(R.drawable.rex1)
            .setAutoCancel(true)
            .build()
        notificationManager.notify(1, notification)
    }
}