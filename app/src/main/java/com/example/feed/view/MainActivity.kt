package com.example.feed.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feed.PostApplication
import com.example.feed.R
import com.example.feed.adapter.PostAdapter
import com.example.feed.viewModel.MainViewModel
import com.example.feed.viewModel.MainViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initAdapter()
        initViewModel()
    }

    fun initAdapter() {
        postAdapter = PostAdapter()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = postAdapter
    }

    fun initViewModel() {
        val postRepository = (application as PostApplication).postRepository

        mainViewModel = ViewModelProvider(this, MainViewModelProvider(postRepository))[MainViewModel::class.java]
        Log.e("ViewModel: ", "$mainViewModel")

        mainViewModel = ViewModelProvider(this, MainViewModelProvider(postRepository))[MainViewModel::class.java]
        Log.e("ViewModel: ", "$mainViewModel")

        mainViewModel.postList.observe(this, Observer { postList ->
            Log.e("Post list", "${postList.size}")
            postAdapter.refreshData(postList)
        })

        mainViewModel.isRefreshing.observe(this, Observer { isRefreshing ->
            Log.e("Is refreshing", "${isRefreshing}")
            swipe_to_refresh.isRefreshing = isRefreshing
        })
    }


}