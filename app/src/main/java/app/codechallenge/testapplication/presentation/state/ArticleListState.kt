package app.codechallenge.testapplication.presentation.state

import app.codechallenge.testapplication.data.model.Article

data class ArticleListState(
    val isLoading : Boolean = false,
    val articles : List<Article>? = null,
    val error : String = ""
)
