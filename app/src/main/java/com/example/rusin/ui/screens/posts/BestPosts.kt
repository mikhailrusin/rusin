package com.example.rusin.ui.screens.posts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rusin.ui.viewmodels.BestPostsViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun BestPosts(modifier: Modifier = Modifier) {
    val bestPostsViewModel: BestPostsViewModel by viewModel { parametersOf(ContentType.Best) }
    PostScreen(viewModel = bestPostsViewModel, modifier)
}