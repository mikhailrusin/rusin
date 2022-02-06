package com.example.rusin.ui.screens

import androidx.compose.runtime.Composable
import com.example.rusin.R
import com.example.rusin.ui.screens.posts.BestPosts
import com.example.rusin.ui.screens.posts.HotPosts
import com.example.rusin.ui.screens.posts.LatestPosts

sealed class TabItem(val title: Int, val screen: @Composable () -> Unit) {
    object Latest : TabItem(R.string.category_latest, { LatestPosts() })
    object Best : TabItem(R.string.category_best, { BestPosts() })
    object Hot : TabItem(R.string.category_hot, { HotPosts() })
}