package com.example.rusin.data.network.model

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    val result: List<PostResponse>
)

data class PostResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("description") val description: String,
    @SerializedName("gifURL") val url: String
)