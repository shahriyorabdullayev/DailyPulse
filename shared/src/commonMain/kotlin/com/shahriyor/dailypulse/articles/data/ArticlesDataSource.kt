package com.shahriyor.dailypulse.articles.data

import shahriyor.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles(): List<ArticleRaw> = database.dailyPulseDatabaseQueries.selectArticles(::mapToArticleRaw).executeAsList()

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { article ->
                database.dailyPulseDatabaseQueries.insertArticle(
                    title = article.title,
                    desc = article.desc,
                    date = article.date,
                    imageUrl = article.imageUrl,
                )
            }
        }
    }

    fun deleteArticles() = database.dailyPulseDatabaseQueries.removeAllArticles()


    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        url: String?,
    ): ArticleRaw = ArticleRaw(
        title = title,
        desc = desc,
        date = date,
        imageUrl = url,
    )
}