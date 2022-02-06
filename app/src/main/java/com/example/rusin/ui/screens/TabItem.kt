package com.example.rusin.ui.screens

import androidx.compose.runtime.Composable

sealed class TabItem(val title: String, val screen: @Composable () -> Unit) {
    object Latest : TabItem("Последние", { ContentScreen(ContentType.Latest) })
    object Best : TabItem("Лучшие", { ContentScreen(ContentType.Best) })
    object Hot : TabItem("Горячие", { ContentScreen(ContentType.Hot) })
}