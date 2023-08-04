package sanzlimited.com.newsapiapp.data.repository.dataSourceImplementation

import retrofit2.Response
import sanzlimited.com.newsapiapp.data.api.NewsAPIService
import sanzlimited.com.newsapiapp.data.model.APIResponse
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsRemoteDataSource

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(countries : String, topic: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(countries, topic, page)
    }

    override suspend fun getSearchedNews(
        countries: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedTopHeadlines(countries, searchQuery, page)
    }
}