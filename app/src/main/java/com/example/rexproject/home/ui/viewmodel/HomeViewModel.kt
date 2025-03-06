package com.example.rexproject.home.ui.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rexproject.R
import com.example.rexproject.core.data.local.shared_preferences.UserPreferences
import com.example.rexproject.home.data.services.GetDinoPetByIdService
import com.example.rexproject.home.data.services.IncreaseCleanDinoPetService
import com.example.rexproject.home.data.services.IncreaseFoodDinoPetService
import com.example.rexproject.home.data.services.IncreaseSanityDinoPetService
import com.example.rexproject.home.domain.adapters.DinoPetStatsAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(app : Application) : AndroidViewModel(app) {
    private val _getDinoPetByIdService = GetDinoPetByIdService()
    private val _userPreferences = UserPreferences(app)
    private val _increaseCleanDinoPetService = IncreaseCleanDinoPetService()
    private val _increaseFoodDinoPetService = IncreaseFoodDinoPetService()
    private val _increaseSanityDinoPetService = IncreaseSanityDinoPetService()
    private val userId = mutableIntStateOf(-1)
    private val dinoPetStats = mutableStateOf<DinoPetStatsAdapter>(
        DinoPetStatsAdapter(
            hp = 100.0,
            food = 100.0,
            sanity = 100.0,
            clean = 100.0
        )
    )

    val rexImg = when (getDinoPetStats().hp.toInt()) {
        in 100 downTo 88 -> R.drawable.rex6
        in 87 downTo 76 -> R.drawable.rex2
        in 75 downTo 64 -> R.drawable.rex5
        in 63 downTo 52 -> R.drawable.rex1
        in 51 downTo 40 -> R.drawable.rex4
        in 39 downTo 28 -> R.drawable.rex7
        in 27 downTo 16 -> R.drawable.rex9
        in 15 downTo 1 -> R.drawable.rex8
        else -> R.drawable.ic_launcher_foreground
    }

    init {
        val userData = _userPreferences.getUserData()
        userId.intValue = userData.id
        startShortPolling()
    }

    fun getDinoPetStats() : DinoPetStatsAdapter {
        return dinoPetStats.value
    }

    fun increaseFood() {
        viewModelScope.launch {
            _increaseFoodDinoPetService.increaseFoodDinoPetById(userId.intValue).onSuccess {
                updateDinoPetStats(it.hp, it.food, it.sanity, it.clean)
            }
        }
    }

    fun increaseSanity() {
        viewModelScope.launch {
            _increaseSanityDinoPetService.increaseSanityDinoPetById(userId.intValue).onSuccess {
                updateDinoPetStats(it.hp, it.food, it.sanity, it.clean)
            }
        }
    }

    fun increaseClean() {
        viewModelScope.launch {
            _increaseCleanDinoPetService.increaseCleanDinoPetById(userId.intValue).onSuccess {
                updateDinoPetStats(it.hp, it.food, it.sanity, it.clean)
            }
        }
    }

    private fun updateDinoPetStats(hp : Double, food : Double, sanity : Double, clean : Double) {
        dinoPetStats.value = DinoPetStatsAdapter(
            hp = hp,
            food = food,
            sanity = sanity,
            clean = clean
        )

    }

    private fun startShortPolling() {
        viewModelScope.launch {
            while (true) {
                _getDinoPetByIdService.getDinoPetById(userId.intValue).onSuccess {
                    updateDinoPetStats(it.hp, it.food, it.sanity, it.clean)
                }
                delay(5 * 60 * 1000)
            }
        }
    }
}