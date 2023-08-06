package sanzlimited.com.newsapiapp.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sanzlimited.com.newsapiapp.data.repository.NewsRepositoryImpl
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsLocalDataSource
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsRemoteDataSource
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ): NewsRepository {
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource)
    }
}