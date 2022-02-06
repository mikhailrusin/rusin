package com.example.rusin.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rusin.ui.viewmodels.LatestPostsViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun LatestPosts(modifier: Modifier = Modifier) {
    val viewModel: LatestPostsViewModel by viewModel { parametersOf(ContentType.Latest) }

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