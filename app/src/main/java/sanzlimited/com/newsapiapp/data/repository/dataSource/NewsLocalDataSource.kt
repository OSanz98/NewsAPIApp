package sanzlimited.com.newsapiapp.data.repository.dataSource

import kotlinx.coroutines.flow.Flow
import sanzlimited.com.newsapiapp.data.model.Article


interface NewsLocalDataSource {
    suspend fun saveArticleToDatabase(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun deleteArticlesFromDB(article: Article)
}