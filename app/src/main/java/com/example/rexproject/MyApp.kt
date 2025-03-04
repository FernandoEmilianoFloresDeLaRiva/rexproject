package com.example.rexproject

import android.app.Application
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Firebase.messaging.token.addOnCompleteListener{
            if(!it.isSuccessful){
                Log.d("TAG_APP", "onCreate: \"El token no fue generado\"")
                return@addOnCompleteListener
            }
            val token = it.result
            Log.d("TAG_APP", "onCreate: $token")
        }
    }
}