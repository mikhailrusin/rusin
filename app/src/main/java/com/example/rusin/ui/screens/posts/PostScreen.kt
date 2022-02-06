package com.example.rusin.ui.screens.posts

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rusin.ui.screens.common.ErrorScreen
import com.example.rusin.ui.screens.common.LoadingScreen
import com.example.rusin.ui.screens.common.PostsViewState
import com.example.rusin.ui.viewmodels.PostsViewModel

@Composable
fun PostScreen(viewModel: PostsViewModel, modifier: Modifier = Modifier) {
    Surface(modifier = modifier.padding(horizontal = 16.dp)) {
        when (viewModel.viewState.observeAsState().value) {
            PostsViewState.Loading -> LoadingScreen()
            PostsViewState.SuccessfulLoad -> {
                viewModel.currentPost?.let {
                    PostContent(
                        it,
                        viewModel.currentPostIndex,
                        onPreviousPost = viewModel::previousPost,
                        onNextPost = viewModel::nextPost
                    )
                }
            }
            PostsViewState.Failure -> ErrorScreen(viewModel::retry)
        }
    }
}