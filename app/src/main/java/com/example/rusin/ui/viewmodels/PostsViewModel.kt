package com.example.rusin.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rusin.domain.interactor.PostsInteractor
import com.example.rusin.domain.model.Post
import com.example.rusin.ui.screens.ContentType
import kotlinx.coroutines.launch

abstract class PostsViewModel(
    private val contentType: ContentType,
    private val interactor: PostsInteractor
) : ViewModel() {

    private var currentPage: Int = START_PAGE

    private val latestPosts = mutableStateListOf<Post>()

    val currentPost: Post?
        get() = latestPosts.getOrNull(currentPostIndex)

    var currentPostIndex: Int by mutableStateOf(-1)


    init {
        getPosts()
    }

    private fun getPosts() {
        viewModelScope.launch {
            runCatching {
                interactor.getLatestPosts(currentPage, contentType.value)
            }.onSuccess { posts ->

                if (posts.isNotEmpty()) {
                    latestPosts.addAll(posts)
                    currentPostIndex++
                }
            }.onFailure {

            }
        }
    }

    fun previousPost() {
        if (currentPostIndex == -1) return

        currentPostIndex -= 1
    }

    fun nextPost() {
        if (currentPostIndex == latestPosts.lastIndex) {
            currentPage += 1
            getPosts()
        }
        else {
            currentPostIndex += 1
        }
    }

    companion object {
        private const val START_PAGE = 0
    }
}