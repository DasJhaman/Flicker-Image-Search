package com.sap.di

import com.sap.domain.usecase.GetAllSearchHistoryUseCase
import com.sap.domain.usecase.SearchPhotosUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::SearchPhotosUseCase)
    singleOf(::GetAllSearchHistoryUseCase)
}