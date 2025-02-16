package com.sap.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module

fun initKoin(additionalModules: List<Module>): KoinApplication {
    return startKoin {
        modules(
            additionalModules +
                    platformModule +
                    appModule +
                    apiModule +
                    repositoryModule +
                    useCaseModule +
                    viewModelModule +
                    dbModule
        )
    }
}