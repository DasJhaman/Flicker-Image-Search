package com.sap.di

import com.sap.data.db.SearchHistoryDao
import com.sap.data.db.SearchHistoryDaoImp
import com.sap.flickersearch.db.Database
import org.koin.dsl.module

val dbModule = module {
    single {
        Database(get())
    }
    single { get<Database>().searchHistoryTableQueries }
    single<SearchHistoryDao> { SearchHistoryDaoImp(get()) }

}