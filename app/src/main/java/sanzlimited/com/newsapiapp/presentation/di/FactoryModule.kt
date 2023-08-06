package sanzlimited.com.newsapiapp.presentation.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sanzlimited.com.newsapiapp.domain.usecase.DeleteSavedNewsUseCase
import sanzlimited.com.newsapiapp.domain.usecase.GetNewsHeadlinesUseCase
import sanzlimited.com.newsapiapp.domain.usecase.GetSavedNewsUseCase
import sanzlimited.com.newsapiapp.domain.usecase.GetSearchedNewsUseCase
import sanzlimited.com.newsapiapp.domain.usecase.SaveNewsUseCase
import sanzlimited.com.newsapiapp.presentation.viewmodel.NewsViewModelFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSavedNewsUseCase: GetSavedNewsUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(application, getNewsHeadlinesUseCase, getSearchedNewsUseCase, saveNewsUseCase, getSavedNewsUseCase, deleteSavedNewsUseCase)
    }

}