package app.codechallenge.testapplication.data.repository

import app.codechallenge.testapplication.data.datasource.network.ApiService
import app.codechallenge.testapplication.data.model.Article
import app.codechallenge.testapplication.data.model.ArticleResponse
import app.codechallenge.testapplication.data.model.InfoResponse
import app.codechallenge.testapplication.domain.repository.RemoteRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepositoryImpl @Inject constructor(private val apiService: ApiService) : RemoteRepository {
    override suspend fun getArticles(): ArticleResponse = apiService.getArticles()

    override suspend fun getArticleDetails(articleId: String?): Article = apiService.getArticleDetails(articleId)

    override suspend fun getInfo(): InfoResponse = apiService.getInfo()

}