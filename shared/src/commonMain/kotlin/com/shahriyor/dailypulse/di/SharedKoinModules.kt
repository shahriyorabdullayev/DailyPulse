package com.shahriyor.dailypulse.di

import com.shahriyor.dailypulse.articles.di.articlesModule

val sharedKoinModules = listOf(
    articlesModule,
    networkModule
)