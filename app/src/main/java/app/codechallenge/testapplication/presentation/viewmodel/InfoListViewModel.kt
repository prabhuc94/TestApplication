package app.codechallenge.testapplication.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.codechallenge.testapplication.app.common.UiState
import app.codechallenge.testapplication.domain.usecase.GetInfosUseCase
import app.codechallenge.testapplication.presentation.state.ArticleDetailState
import app.codechallenge.testapplication.presentation.state.InfoListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class InfoListViewModel @Inject constructor(private val infosUseCase: GetInfosUseCase) : ViewModel() {

    private val _infos = mutableStateOf(InfoListState())
    val infos : State<InfoListState> get() = _infos

    init {
        infosUseCase().onEach {
            _infos.value = when(it) {
                is UiState.Loading -> InfoListState(isLoading = true)
                is UiState.Success -> InfoListState(infos = it.data?.newsSites)
                is UiState.Error -> InfoListState(error = it.message.toString())
            }
        }.launchIn(viewModelScope)
    }
}