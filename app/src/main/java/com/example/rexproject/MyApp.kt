package com.example.rexproject

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.util.Log
import com.example.rexproject.core.data.local.shared_preferences.UserPreferences
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

class MyApp : Application() {
    companion object {
        const val NOTIFICATION_CHANNEL_ID = "notification_fcm"
    }

    override fun onCreate() {
        super.onCreate()
        Firebase.messaging.token.addOnCompleteListener{
            if(!it.isSuccessful){
                Log.d("TAG_APP", "onCreate: \"El token no fue generado\"")
                return@addOnCompleteListener
            }
            val token = it.result
            saveTokenToPreferences(token)
        }
        createNotificationChannel()
    }

    private fun saveTokenToPreferences(token : String){
        val userPreferences = UserPreferences(this)
        userPreferences.saveToken(token)
        Log.d("TAG_APP", "Token $token guardado en shared preferences exitosamente")
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Notificaciones de FCM",
                NotificationManager.IMPORTANCE_HIGH,
            )
            channel.description = "Estas notificaciones van a ser recibidas desde FCM"
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}