package com.example.rusin.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class ContentType { Latest, Best, Hot }

@Composable
fun ContentScreen(contentType: ContentType, modifier: Modifier = Modifier) {
    Surface(modifier = modifier.padding(horizontal = 16.dp)) {
        PostContent()
    }
}