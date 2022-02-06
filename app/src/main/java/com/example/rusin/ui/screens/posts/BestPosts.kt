package com.example.rusin.ui.screens.posts

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rusin.ui.viewmodels.BestPostsViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun BestPosts(modifier: Modifier = Modifier) {
    val viewModel: BestPostsViewModel by viewModel { parametersOf(ContentType.Best) }

    Surface(modifier = modifier.padding(horizontal = 16.dp)) {
        viewModel.currentPost?.let {
            PostContent(
                it,
                viewModel.currentPostIndex,
                onPreviousPost = viewModel::previousPost,
                onNextPost = viewModel::nextPost
            )
        }
    }
}