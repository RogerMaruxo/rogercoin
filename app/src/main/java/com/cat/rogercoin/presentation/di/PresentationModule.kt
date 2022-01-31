package com.cat.rogercoin.presentation.di

import com.cat.rogercoin.presentation.HistoryViewModel
import com.cat.rogercoin.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object PresentationModule {
    fun load (){
        loadKoinModules(viewModelModules())
    }

    private fun viewModelModules(): Module {
        return module {
            viewModel{ MainViewModel(get(), get()) }
            viewModel{ HistoryViewModel(get()) }
        }
    }
}