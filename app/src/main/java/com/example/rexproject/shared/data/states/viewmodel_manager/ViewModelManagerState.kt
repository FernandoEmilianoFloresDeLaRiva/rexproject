package com.example.rexproject.shared.data.states.viewmodel_manager

import androidx.compose.runtime.compositionLocalOf
import com.example.rexproject.core.domain.models.ViewModelManager

val LocalViewModelProvider = compositionLocalOf<ViewModelManager> {
    error("No ViewModelProvider found in CompositionLocal")
}