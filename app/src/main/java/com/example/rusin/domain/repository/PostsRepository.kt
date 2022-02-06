package com.example.rusin.domain.repository

import com.example.rusin.domain.model.Post

interface PostsRepositoryI {
    suspend fun getLatestPosts(page: Int, contentType: String): List<Post>
}