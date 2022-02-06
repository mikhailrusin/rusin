package com.example.rusin.domain.interactor

import com.example.rusin.domain.repository.PostsRepositoryI

class PostsInteractor(
    private val repository: PostsRepositoryI
) {
    suspend fun getLatestPosts(page: Int, contentType: String) =
        repository.getLatestPosts(page, contentType)
}