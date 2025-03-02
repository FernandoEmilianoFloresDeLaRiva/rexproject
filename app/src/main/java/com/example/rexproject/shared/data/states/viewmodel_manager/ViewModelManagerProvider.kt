package com.example.rexproject.shared.data.states.viewmodel_manager

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.rexproject.core.domain.models.ViewModelManager

@Composable
fun ViewModelManagerProvider(
    ctx : Context,
    content: @Composable () -> Unit
) {
    val viewModelManager = remember{ ViewModelManager(ctx = ctx) }
    
    CompositionLocalProvider(LocalViewModelProvider provides viewModelManager) {
        content()
    }
}