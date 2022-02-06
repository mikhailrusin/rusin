package com.example.rusin.ui.screens.posts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.rusin.ui.viewmodels.HotPostsViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun HotPosts(modifier: Modifier = Modifier) {
    val hotPostsViewModel: HotPostsViewModel by viewModel { parametersOf(ContentType.Hot) }
    PostScreen(viewModel = hotPostsViewModel, modifier)
}