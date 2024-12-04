package app.codechallenge.testapplication.domain.usecase

import app.codechallenge.testapplication.app.common.UiState
import app.codechallenge.testapplication.data.model.InfoResponse
import app.codechallenge.testapplication.domain.repository.RemoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetInfosUseCase @Inject constructor(private val remoteRepository: RemoteRepository)  {

    operator fun invoke() : Flow<UiState<InfoResponse>> = flow {
        emit(UiState.Loading())
        try {
            emit(UiState.Success(remoteRepository.getInfo()))
        } catch (e : Exception) {
            emit(UiState.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)
}