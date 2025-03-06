package com.example.rexproject.core.domain.models

import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.rexproject.create_user.ui.viewmodel.CreateUserViewModel
import com.example.rexproject.home.ui.viewmodel.HomeViewModel

class ViewModelManager(private val ctx : Context){
    private val viewModelCache = mutableMapOf<Class <out AndroidViewModel>, AndroidViewModel>()

    private fun <T : AndroidViewModel> getViewModel(viewModelClass: Class<T>): T {
        val cachedViewModel = viewModelCache[viewModelClass]

        cachedViewModel?.let {
            @Suppress("UNCHECKED_CAST")
            return it as T
        }

        val viewModelStoreOwner = ctx as? ViewModelStoreOwner
            ?: throw IllegalArgumentException("Context must be a ViewModelStoreOwner")

        val viewModel = ViewModelProvider(viewModelStoreOwner)[viewModelClass]

        viewModelCache[viewModelClass] = viewModel

        return viewModel
    }

    val createUserViewModel: CreateUserViewModel by lazy {
        getViewModel(CreateUserViewModel::class.java)
    }

    val homeViewModel: HomeViewModel by lazy {
        getViewModel(HomeViewModel::class.java)
    }
}