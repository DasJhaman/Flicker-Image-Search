package com.sap.di

import com.sap.data.remote.SearchApi
import com.sap.data.remote.SearchApiImp
import org.koin.dsl.module

internal val apiModule = module {
    single<SearchApi> { SearchApiImp(get()) }
}