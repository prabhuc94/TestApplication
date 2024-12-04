package app.codechallenge.testapplication.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.codechallenge.testapplication.app.common.UiState
import app.codechallenge.testapplication.domain.usecase.GetArticlesUseCase
import app.codechallenge.testapplication.presentation.state.ArticleListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(private val articlesUseCase: GetArticlesUseCase) : ViewModel() {

    private val _articleList = mutableStateOf(ArticleListState())
    val articleList : State<ArticleListState> get() = _articleList

    init {
        articlesUseCase().onEach {
            when(it) {
                is UiState.Loading -> _articleList.value = ArticleListState(isLoading = true)
                is UiState.Success -> _articleList.value = ArticleListState(articles = it.data?.results)
                is UiState.Error -> _articleList.value = ArticleListState(error = it.message.toString())
            }
        }.launchIn(viewModelScope)
    }
}