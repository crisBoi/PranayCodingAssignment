package com.example.feed

import android.app.Application
import com.example.feed.repository.PostRepository

class PostApplication: Application() {

    lateinit var postRepository: PostRepository

    override fun onCreate() {
        super.onCreate()

        postRepository = PostRepository()
    }
}