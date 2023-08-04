package sanzlimited.com.newsapiapp.domain.usecase

import sanzlimited.com.newsapiapp.data.model.APIResponse
import sanzlimited.com.newsapiapp.data.util.Resource
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchedNews(searchQuery)
    }
}