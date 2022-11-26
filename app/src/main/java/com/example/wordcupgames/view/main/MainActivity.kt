package com.example.wordcupgames.view.main

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordcupgames.R
import com.example.wordcupgames.databinding.ActivityMainBinding
import com.example.wordcupgames.view.adapters.MatchesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()
    private val matchesAdapter: MatchesAdapter by lazy {
        MatchesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAdapter()
        setupObservers()
        setStatusBarGradiant(this)
    }

    private fun setupObservers() {
        viewModel.matches.observe(this, Observer {
            matchesAdapter.submitList(it)
        })
    }

    private fun handleRequest(state: MatchesUiState) {
        matchesAdapter.submitList(state.matches)
    }

    private fun setupAdapter() {
        binding.rvScores.adapter = matchesAdapter
        binding.rvScores.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    private fun setupView() {
        setupToolBar()

    }

    private fun setupToolBar() {
        binding.toolbar.tvDate.text = "20/11/2022"
    }

    private fun setStatusBarGradiant(activity: Activity) {
        val window: Window = activity.window
        val background = ContextCompat.getDrawable(activity, R.drawable.red_gradient)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        window.statusBarColor = ContextCompat.getColor(activity, android.R.color.transparent)
        window.setBackgroundDrawable(background)
    }
}