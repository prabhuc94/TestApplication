package app.codechallenge.testapplication.app.di

import app.codechallenge.testapplication.domain.repository.RemoteRepository
import app.codechallenge.testapplication.domain.usecase.GetArticleDetailUseCase
import app.codechallenge.testapplication.domain.usecase.GetArticlesUseCase
import app.codechallenge.testapplication.domain.usecase.GetInfosUseCase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Singleton
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetArticlesUseCase(remoteRepository: RemoteRepository) = GetArticlesUseCase(remoteRepository)

    @Singleton
    @Provides
    fun provideGetArticleDetailUseCase(remoteRepository: RemoteRepository) = GetArticleDetailUseCase(remoteRepository)

    @Singleton
    @Provides
    fun provideGetInfosUseCase(remoteRepository: RemoteRepository) = GetInfosUseCase(remoteRepository)

}