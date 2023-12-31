package sanzlimited.com.newsapiapp.domain.repository

import kotlinx.coroutines.flow.Flow
import sanzlimited.com.newsapiapp.data.model.APIResponse
import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.data.util.Resource

interface NewsRepository {

    suspend fun getNewsHeadlines(countries : String, topic: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(countries: String, searchQuery: String, page: Int) : Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}