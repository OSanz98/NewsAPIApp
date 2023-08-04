package sanzlimited.com.newsapiapp.domain.usecase

import kotlinx.coroutines.flow.Flow
import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}