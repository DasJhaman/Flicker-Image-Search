package com.sap.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.sap.flickersearch.db.Database
import io.ktor.client.engine.darwin.Darwin
import org.koin.dsl.module

actual val platformModule = module {
    single {
        Darwin.create()
    }

    single<SqlDriver> {
        NativeSqliteDriver(Database.Schema, "flickerImageSearch.db")
    }
}