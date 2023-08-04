package sanzlimited.com.newsapiapp.data.repository.dataSource

import retrofit2.Response
import sanzlimited.com.newsapiapp.data.model.APIResponse

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(countries : String, topic: String): Response<APIResponse>
}