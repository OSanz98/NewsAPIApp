package sanzlimited.com.newsapiapp.domain.usecase

import sanzlimited.com.newsapiapp.data.model.APIResponse
import sanzlimited.com.newsapiapp.data.util.Resource
import sanzlimited.com.newsapiapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(countries : String, topic: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(countries, topic, page)
    }
}