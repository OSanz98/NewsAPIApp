package sanzlimited.com.newsapiapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import sanzlimited.com.newsapiapp.data.model.APIResponse
import sanzlimited.com.newsapiapp.data.model.Article
import sanzlimited.com.newsapiapp.data.util.Resource
import sanzlimited.com.newsapiapp.domain.usecase.DeleteSavedNewsUseCase
import sanzlimited.com.newsapiapp.domain.usecase.GetNewsHeadlinesUseCase
import sanzlimited.com.newsapiapp.domain.usecase.GetSavedNewsUseCase
import sanzlimited.com.newsapiapp.domain.usecase.GetSearchedNewsUseCase
import sanzlimited.com.newsapiapp.domain.usecase.SaveNewsUseCase
import java.lang.Exception

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val savedNewsUseCase: SaveNewsUseCase,
    private val getSavedNewsUseCase: GetSavedNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
): AndroidViewModel(app) {
    val newsHeadlines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getNewsHeadlines(countries : String, topic: String, page: Int) = viewModelScope.launch(Dispatchers.IO){
        newsHeadlines.postValue(Resource.Loading())
        try {
            if(isNetworkAvailable(app)){
                newsHeadlines.postValue(Resource.Loading())
                val apiResult = getNewsHeadlinesUseCase.execute(countries, topic, page)
                newsHeadlines.postValue(apiResult)
            } else {
                newsHeadlines.postValue(Resource.Error("Internet is not available."))
            }
        }catch (e: Exception){
            newsHeadlines.postValue(Resource.Error(e.message.toString()))
        }

    }

    private fun isNetworkAvailable(context: Context?): Boolean{
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }

    val searchedNews : MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun searchNews(
        countries: String,
        searchQuery : String,
        page: Int
    ) = viewModelScope.launch {
        searchedNews.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val response = getSearchedNewsUseCase.execute(
                    countries,
                    searchQuery,
                    page
                )
                searchedNews.postValue(response)
            } else {
                searchedNews.postValue(Resource.Error("No internet connection"))
            }
        }catch(e:Exception){
            searchedNews.postValue(Resource.Error(e.message.toString()))
        }
    }

//    save to local data
    fun saveArticle(article: Article) = viewModelScope.launch {
        savedNewsUseCase.execute(article)
    }

    fun getSavedNews() = liveData {
        getSavedNewsUseCase.execute().collect {
            emit(it)
        }
    }
    fun deleteArticle(article: Article) = viewModelScope.launch {
        deleteSavedNewsUseCase.execute(article)
    }


}