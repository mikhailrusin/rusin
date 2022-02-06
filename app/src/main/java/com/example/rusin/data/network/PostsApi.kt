package com.example.rusin.data.network

import com.example.rusin.data.network.model.ResultResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PostsApi {
    @GET("/{type}/{page}?json=true")
    suspend fun getPosts(@Path("page") page: Int, @Path("type") contentType: String): ResultResponse
}