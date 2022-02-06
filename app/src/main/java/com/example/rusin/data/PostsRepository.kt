package com.example.rusin.data

import com.example.rusin.data.common.mapToDomain
import com.example.rusin.data.network.PostsApi
import com.example.rusin.domain.repository.PostsRepositoryI

class PostsRepository(
    private val api: PostsApi
) : PostsRepositoryI {
    override suspend fun getLatestPosts(page: Int, contentType: String) =
        api.getPosts(page, contentType).result.map { it.mapToDomain() }
}