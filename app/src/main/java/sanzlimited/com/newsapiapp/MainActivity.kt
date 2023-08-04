package sanzlimited.com.newsapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import sanzlimited.com.newsapiapp.databinding.ActivityMainBinding
import sanzlimited.com.newsapiapp.presentation.adapter.NewsAdapter
import sanzlimited.com.newsapiapp.presentation.viewmodel.NewsViewModel
import sanzlimited.com.newsapiapp.presentation.viewmodel.NewsViewModelFactory
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: NewsViewModelFactory
    @Inject
    lateinit var newsAdapter: NewsAdapter
    lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavNews.setupWithNavController(
            navController
        )

        viewModel = ViewModelProvider(this, factory)[NewsViewModel::class.java]
    }
}