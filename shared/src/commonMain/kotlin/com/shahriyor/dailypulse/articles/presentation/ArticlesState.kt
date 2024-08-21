package com.shahriyor.dailypulse.articles.presentation

import com.shahriyor.dailypulse.articles.application.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)