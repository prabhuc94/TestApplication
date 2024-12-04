package app.codechallenge.testapplication.app.di

import app.codechallenge.testapplication.data.repository.RemoteRepositoryImpl
import app.codechallenge.testapplication.data.datasource.network.ApiService
import app.codechallenge.testapplication.domain.repository.RemoteRepository
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Singleton
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRemoteRepository(apiService: ApiService): RemoteRepository = RemoteRepositoryImpl(apiService)

}