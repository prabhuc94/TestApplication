package app.codechallenge.testapplication.presentation.state

import app.codechallenge.testapplication.data.model.Article

data class ArticleDetailState(
    val isLoading : Boolean = false,
    val article : Article? = null,
    val error : String = ""
)
