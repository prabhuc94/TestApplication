package app.codechallenge.testapplication.app.di

import app.codechallenge.testapplication.app.navigation.AppNavigator
import app.codechallenge.testapplication.app.navigation.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Singleton
    @Binds
    fun bindNavigator(appNavigatorImpl: AppNavigatorImpl) : AppNavigator

}