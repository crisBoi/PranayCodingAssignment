package com.example.feed.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feed.models.Post
import com.example.feed.repository.PostRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PostRepository): ViewModel() {

    init {
        viewModelScope.launch {
            repository.fetchUserData()
        }

    }

    val postList: LiveData<List<Post>>
    get() = repository.postList

    val isRefreshing: LiveData<Boolean>
    get() = repository.isRefreshing
}