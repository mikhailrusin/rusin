package com.example.rusin.ui.screens.common

sealed class PostsViewState {
    object Loading : PostsViewState()
    object SuccessfulLoad : PostsViewState()
    object Failure: PostsViewState()
}