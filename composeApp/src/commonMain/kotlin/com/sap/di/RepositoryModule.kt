package com.sap.di

import com.sap.data.repo.SearchRepositoryImp
import com.sap.domain.SearchRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val repositoryModule = module {
    single<SearchRepository> { SearchRepositoryImp(get(), get()) }
}