package app.codechallenge.testapplication.data.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("articles")
    suspend fun getArticles(
        @Query("search") source: String?,
        @Query("has_event") hasEvent: Boolean?,
        @Query("has_launch") hasLaunch: Boolean?,
        @Query("is_featured") isFeatured: Boolean?,
        @Query("news_site") newsSites : String?
    )

    @GET("articles/{id}/")
    suspend fun getArticleDetails(
        @Path("id") articleId : String?
    )

    @GET("info")
    suspend fun getInfo()

}