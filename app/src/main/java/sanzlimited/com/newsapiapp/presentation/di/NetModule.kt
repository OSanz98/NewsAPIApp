package sanzlimited.com.newsapiapp.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sanzlimited.com.newsapiapp.BuildConfig
import sanzlimited.com.newsapiapp.data.api.NewsAPIService
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit): NewsAPIService {
        return retrofit.create(NewsAPIService::class.java)
    }
}