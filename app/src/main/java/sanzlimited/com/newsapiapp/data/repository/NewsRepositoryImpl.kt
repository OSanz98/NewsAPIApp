package sanzlimited.com.newsapiapp.data.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import sanzlimited.com.newsapiapp.data.model.APIResponse
import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsLocalDataSource
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsRemoteDataSource
import sanzlimited.com.newsapiapp.data.util.Resource
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource

): NewsRepository {
    override suspend fun getNewsHeadlines(countries : String, topic: String, page: Int): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(countries, topic, page))
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse> {
        return responseToResource(
            newsRemoteDataSource.getSearchedNews(country,searchQuery,page)
        )
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDatabase(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsLocalDataSource.deleteArticlesFromDB(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsLocalDataSource.getSavedArticles()
    }
}