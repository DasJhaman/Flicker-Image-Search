package com.sap.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.sap.flickersearch.db.Database
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.dsl.module


actual val platformModule = module {
    single {
        OkHttp.create()
    }
    single<SqlDriver> {
        AndroidSqliteDriver(
            schema = Database.Schema,
            context = get(),
            name = "flickerImageSearch.db"
        )
    }
}