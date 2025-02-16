package com.sap

import android.app.Application
import android.content.Context
import com.sap.di.initKoin
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(listOf(module {
            single<Context> { this@MainApplication }
        }))
    }
}