package com.example.feed.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.feed.models.Post
import kotlinx.coroutines.delay

class PostRepository {

    private val postListLiveData: MutableLiveData<List<Post>> = MutableLiveData()
   val isRefreshing: MutableLiveData<Boolean> = MutableLiveData()

    init {
        isRefreshing.value = false
    }

    val postList: LiveData<List<Post>>
    get() = postListLiveData



    suspend fun fetchUserData() {
        isRefreshing.postValue(true)
        delay(4000)

        val posts = createDummyData()
        postListLiveData.postValue(posts)

        isRefreshing.postValue(false)
    }

    private fun createDummyData(): List<Post> {
        val posts = mutableListOf<Post>()
        posts.add(Post("Pranay", "Android developer", "Today is a great day", "", 29, 34))
        posts.add(Post("Raj", "Senior developer", "Howdy", "", 50, 34))
        posts.add(Post("Radzz", "Frontend", "Today is a great day", "", 29, 34))
        posts.add(Post("Pranay", "Android developer", "Today is a great day", "", 29, 34))
        posts.add(Post("Raj", "Senior developer", "Howdy", "", 50, 34))
        posts.add(Post("Radzz", "Frontend", "Today is a great day", "", 29, 34))
        posts.add(Post("Pranay", "Android developer", "Today is a great day", "", 29, 34))
        posts.add(Post("Raj", "Senior developer", "Howdy", "", 50, 34))
        posts.add(Post("Radzz", "Frontend", "Today is a great day", "", 29, 34))
        return posts
    }
}