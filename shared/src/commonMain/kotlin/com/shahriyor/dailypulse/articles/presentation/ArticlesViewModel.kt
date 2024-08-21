package com.shahriyor.dailypulse.articles.presentation


import com.shahriyor.dailypulse.BaseViewModel
import com.shahriyor.dailypulse.articles.application.ArticlesUseCase
import com.shahriyor.dailypulse.articles.presentation.ArticlesState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val articlesUseCase: ArticlesUseCase
) : BaseViewModel() {

    private val _articlesState: MutableStateFlow<ArticlesState> =
        MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articlesState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false) {
        scope.launch {
            _articlesState.emit(ArticlesState(loading = true, articles = _articlesState.value.articles))
            val fetchedArticles = articlesUseCase.getArticles(forceFetch)
            delay(500)
            _articlesState.emit(ArticlesState(articles = fetchedArticles))
        }
    }
}