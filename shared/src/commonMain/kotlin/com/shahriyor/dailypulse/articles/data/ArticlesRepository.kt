package com.shahriyor.dailypulse.articles.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw> {
        if (forceFetch) {
            dataSource.deleteArticles()
            return fetchArticles()
        }
        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} articles from db")

        if (articlesDb.isEmpty()) {
            return fetchArticles()
        }
        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        val articles = service.fetchArticles()
        dataSource.insertArticles(articles)
        return articles
    }
}