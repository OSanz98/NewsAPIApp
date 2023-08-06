package sanzlimited.com.newsapiapp.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sanzlimited.com.newsapiapp.data.db.ArticleDAO
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsLocalDataSource
import sanzlimited.com.newsapiapp.data.repository.dataSourceImplementation.NewsLocalDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDAO: ArticleDAO): NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDAO)
    }

}