package app.codechallenge.testapplication.domain.repository

import app.codechallenge.testapplication.data.model.Article
import app.codechallenge.testapplication.data.model.ArticleResponse
import app.codechallenge.testapplication.data.model.InfoResponse

interface RemoteRepository {
    suspend fun getArticles() : ArticleResponse
    suspend fun getArticleDetails(articleId : String?) : Article
    suspend fun getInfo() : InfoResponse
}