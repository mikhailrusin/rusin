package com.example.rusin.ui.screens

import androidx.compose.runtime.Composable

sealed class TabItem(val title: String, val screen: @Composable () -> Unit) {
    object Latest : TabItem("Последние", { LatestPosts() })
    object Best : TabItem("Лучшие", { BestPosts() })
    object Hot : TabItem("Горячие", { HotPosts() })
}