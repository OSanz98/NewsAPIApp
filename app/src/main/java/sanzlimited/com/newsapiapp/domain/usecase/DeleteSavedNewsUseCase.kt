package sanzlimited.com.newsapiapp.domain.usecase

import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}