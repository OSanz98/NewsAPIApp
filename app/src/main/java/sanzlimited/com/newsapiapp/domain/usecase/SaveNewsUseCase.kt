package sanzlimited.com.newsapiapp.domain.usecase

import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}