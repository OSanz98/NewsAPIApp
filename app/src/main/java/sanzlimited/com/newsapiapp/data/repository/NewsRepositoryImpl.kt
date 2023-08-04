package sanzlimited.com.newsapiapp.data.repository

import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import sanzlimited.com.newsapiapp.data.model.APIResponse
import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsRemoteDataSource
import sanzlimited.com.newsapiapp.data.util.Resource
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource

): NewsRepository {
    override suspend fun getNewsHeadlines(countries : String, topic: String): Resource<APIResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(countries, topic))
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse>{
        if(response.isSuccessful){
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}