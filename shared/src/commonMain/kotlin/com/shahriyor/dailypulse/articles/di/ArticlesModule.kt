package com.shahriyor.dailypulse.articles.di

import com.shahriyor.dailypulse.articles.data.ArticlesDataSource
import com.shahriyor.dailypulse.articles.data.ArticlesRepository
import com.shahriyor.dailypulse.articles.data.ArticlesService
import com.shahriyor.dailypulse.articles.application.ArticlesUseCase
import com.shahriyor.dailypulse.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}