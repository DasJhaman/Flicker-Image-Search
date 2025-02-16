package com.sap.di

import com.sap.presentation.dashboard.DashboardScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::DashboardScreenViewModel)
}