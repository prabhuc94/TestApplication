package app.codechallenge.testapplication.domain.usecase

import app.codechallenge.testapplication.app.common.UiState
import app.codechallenge.testapplication.data.model.ArticleResponse
import app.codechallenge.testapplication.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val remoteRepository: RemoteRepository) {
    operator fun invoke() : Flow<UiState<ArticleResponse>> = flow {
        emit(UiState.Loading())
        try {
            emit(UiState.Success(remoteRepository.getArticles()))
        } catch (e : Exception) {
            emit(UiState.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}