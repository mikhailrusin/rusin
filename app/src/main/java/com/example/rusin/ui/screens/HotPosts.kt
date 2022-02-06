package com.example.rusin.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rusin.ui.viewmodels.HotPostsViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun HotPosts(modifier: Modifier = Modifier) {
    val viewModel: HotPostsViewModel by viewModel { parametersOf(ContentType.Hot) }

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