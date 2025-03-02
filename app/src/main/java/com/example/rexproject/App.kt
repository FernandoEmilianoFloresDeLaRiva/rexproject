package com.example.rexproject

import android.content.Context
import androidx.compose.runtime.Composable
import com.example.rexproject.core.ui.router.IndexRouter
import com.example.rexproject.shared.data.states.user.UserProvider
import com.example.rexproject.shared.data.states.viewmodel_manager.ViewModelManagerProvider

@Composable
fun App(
    ctx : Context,
) {
    ViewModelManagerProvider(ctx = ctx) {
        UserProvider {
            IndexRouter(
                ctx = ctx
            )
        }
    }
}
