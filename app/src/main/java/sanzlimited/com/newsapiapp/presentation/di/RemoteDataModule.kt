package sanzlimited.com.newsapiapp.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sanzlimited.com.newsapiapp.data.api.NewsAPIService
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsRemoteDataSource
import sanzlimited.com.newsapiapp.data.repository.dataSourceImplementation.NewsRemoteDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}