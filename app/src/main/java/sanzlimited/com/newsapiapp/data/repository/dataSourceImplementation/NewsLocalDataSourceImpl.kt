package sanzlimited.com.newsapiapp.data.repository.dataSourceImplementation

import kotlinx.coroutines.flow.Flow
import sanzlimited.com.newsapiapp.data.db.ArticleDAO
import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.data.repository.dataSource.NewsLocalDataSource


class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
): NewsLocalDataSource {
    override suspend fun saveArticleToDatabase(article: Article) {
        articleDAO.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDAO.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDAO.deleteArticle(article)
    }
}