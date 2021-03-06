package com.example.rusin.ui.viewmodels

import com.example.rusin.domain.interactor.PostsInteractor
import com.example.rusin.ui.screens.posts.ContentType

class BestPostsViewModel(
    contentType: ContentType,
    interactor: PostsInteractor
) : PostsViewModel(contentType, interactor)