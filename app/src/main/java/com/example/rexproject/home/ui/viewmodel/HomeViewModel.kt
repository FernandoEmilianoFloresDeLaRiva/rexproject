package com.example.rexproject.home.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.lifecycle.AndroidViewModel

class HomeViewModel(app : Application) : AndroidViewModel(app) {
    val _hp = mutableDoubleStateOf(0.1)

    fun updateHp(hp : Double) {
        _hp.doubleValue = hp
    }

    fun getHp() : Double {
        return _hp.doubleValue
    }
}