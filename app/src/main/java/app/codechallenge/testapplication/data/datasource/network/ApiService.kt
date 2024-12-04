package app.codechallenge.testapplication.data.datasource.network

import app.codechallenge.testapplication.data.model.Article
import app.codechallenge.testapplication.data.model.ArticleResponse
import app.codechallenge.testapplication.data.model.InfoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("articles")
    suspend fun getArticles(
        @Query("search") source: String ?= null,
        @Query("has_event") hasEvent: Boolean ?= null,
        @Query("has_launch") hasLaunch: Boolean ?= null,
        @Query("is_featured") isFeatured: Boolean ?= null,
        @Query("news_site") newsSites : String ?= null
    ) : ArticleResponse

    @GET("articles/{id}/")
    suspend fun getArticleDetails(
        @Path("id") articleId : String?
    ) : Article

    @GET("info")
    suspend fun getInfo() : InfoResponse

}