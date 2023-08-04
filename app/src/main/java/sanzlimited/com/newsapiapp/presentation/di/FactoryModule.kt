package sanzlimited.com.newsapiapp.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sanzlimited.com.newsapiapp.domain.usecase.GetNewsHeadlinesUseCase
import sanzlimited.com.newsapiapp.presentation.viewmodel.NewsViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        application: Application
    ): NewsViewModelFactory {
        return NewsViewModelFactory(getNewsHeadlinesUseCase, application)
    }

}