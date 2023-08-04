package sanzlimited.com.newsapiapp.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import sanzlimited.com.newsapiapp.BuildConfig
import sanzlimited.com.newsapiapp.data.model.APIResponse

interface NewsAPIService {
    @GET("v2/latest_headlines")
    suspend fun getTopHeadlines(
        @Query("countries")
        countries: String,
        @Query("topic")
        topic:String,
        @Header("x-api-key")
        apiKey:String = BuildConfig.API_KEY
    ): Response<APIResponse>
}