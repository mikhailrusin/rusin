package com.example.rusin.data.common

import com.example.rusin.data.network.model.PostResponse
import com.example.rusin.domain.model.Post

fun PostResponse.mapToDomain() =
    Post(
        id = id,
        description = description,
        url = url
    )