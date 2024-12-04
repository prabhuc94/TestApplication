package app.codechallenge.testapplication.data.model

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Article>
)

data class Article(
    val events: List<Event>,
    val featured: Boolean,
    val id: Int,
    @SerializedName("image_url")
    val imageUrl: String,
    val launches: List<Launches>,
    @SerializedName("news_site")
    val newsSite: String,
    @SerializedName("published_at")
    val publishedAt: String,
    val summary: String,
    val title: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val url: String
)

data class Event(
    @SerializedName("event_id")
    val eventId: Int,
    val provider: String
)

data class Launches(
    @SerializedName("launch_id")
    val launchId: String,
    val provider: String
)

data class InfoResponse(
    @SerializedName("news_sites")
    val newsSites: List<String>,
    val version: String
)
