package com.example.rusin.ui.screens.posts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rusin.ui.viewmodels.LatestPostsViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun LatestPosts(modifier: Modifier = Modifier) {
    val latestPostsViewModel: LatestPostsViewModel by viewModel { parametersOf(ContentType.Latest) }
    PostScreen(viewModel = latestPostsViewModel, modifier)
}