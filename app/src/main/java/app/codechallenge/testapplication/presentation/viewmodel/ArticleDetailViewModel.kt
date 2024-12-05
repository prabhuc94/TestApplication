package app.codechallenge.testapplication.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.codechallenge.testapplication.app.common.UiState
import app.codechallenge.testapplication.domain.usecase.GetArticleDetailUseCase
import app.codechallenge.testapplication.presentation.state.ArticleDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(private val articleDetailUseCase: GetArticleDetailUseCase) : ViewModel() {

    private val _articleDetails = mutableStateOf(ArticleDetailState())
    val articleDetail : State<ArticleDetailState> get() = _articleDetails


    fun getArticleDetails(articleId : String?) {
        articleDetailUseCase(articleId).onEach {
            when(it) {
                is UiState.Loading -> _articleDetails.value = ArticleDetailState(isLoading = true)
                is UiState.Success -> _articleDetails.value = ArticleDetailState(article = it.data)
                is UiState.Error -> _articleDetails.value = ArticleDetailState(error = it.message.toString())
            }
        }.launchIn(viewModelScope)
    }
}