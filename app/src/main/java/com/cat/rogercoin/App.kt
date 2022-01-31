package com.cat.rogercoin

import android.app.Application
import com.cat.rogercoin.data.di.DataModules
import com.cat.rogercoin.domain.di.DomainModule
import com.cat.rogercoin.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate(){
        super.onCreate()
        startKoin {
            androidContext(this@App)
        }

        DataModules.load()
        DomainModule.load()
        PresentationModule.load()
    }
}