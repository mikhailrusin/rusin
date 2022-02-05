package com.example.rusin.ui.screens

import androidx.compose.runtime.Composable
import com.example.rusin.ScreenOne
import com.example.rusin.ScreenThree
import com.example.rusin.ScreenTwo

sealed class TabItem(val title: String, val screen: @Composable () -> Unit) {
    object Latest : TabItem("Последние", { ScreenOne() })
    object Best : TabItem("Лучшие", { ScreenTwo() })
    object Hot : TabItem("Горячие", { ScreenThree() })
}