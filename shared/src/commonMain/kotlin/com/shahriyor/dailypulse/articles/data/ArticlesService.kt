package com.shahriyor.dailypulse.articles.data

import com.shahriyor.dailypulse.articles.data.ArticleRaw
import com.shahriyor.dailypulse.articles.data.ArticlesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "49c3cafa317847bc880c0ca6b0afb05e"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }
}