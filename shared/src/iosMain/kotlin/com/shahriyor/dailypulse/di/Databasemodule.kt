package com.shahriyor.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.shahriyor.dailypulse.db.DatabaseDriverFactory
import org.koin.dsl.module
import shahriyor.dailypulse.db.DailyPulseDatabase

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }

    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}