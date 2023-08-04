package sanzlimited.com.newsapiapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sanzlimited.com.newsapiapp.domain.usecase.GetNewsHeadlinesUseCase

class NewsViewModelFactory(
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val app: Application
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            getNewsHeadlinesUseCase,
            app
        ) as T
    }
}