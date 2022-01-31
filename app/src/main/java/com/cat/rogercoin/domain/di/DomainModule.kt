package com.cat.rogercoin.domain.di

import com.cat.rogercoin.domain.GetExchangeValueUseCase
import com.cat.rogercoin.domain.ListExchangeUseCase
import com.cat.rogercoin.domain.SaveExchangeUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load(){
        loadKoinModules(useCaseModules())
    }

    private fun useCaseModules(): Module {
        return module {
            factory { ListExchangeUseCase(get())}
            factory { SaveExchangeUseCase(get())}
            factory { GetExchangeValueUseCase(get())}
        }
    }
}