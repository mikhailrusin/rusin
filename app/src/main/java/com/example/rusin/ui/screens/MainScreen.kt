package com.example.rusin.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val tabs = listOf(TabItem.Latest, TabItem.Best, TabItem.Hot)
    val pagerState = rememberPagerState(pageCount = tabs.size)

    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
        Scaffold(
            topBar = { TopBar() }
        ) {
            Column {
                Tabs(tabs, pagerState)
                TabsContent(tabs, pagerState)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState, modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        indicator = { pos ->
            TabRowDefaults.Indicator(
                modifier
                    .padding(horizontal = 8.dp)
                    .pagerTabIndicatorOffset(
                        pagerState,
                        pos
                    )
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(stringResource(id = tab.title)) }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    val tabs = listOf(
        TabItem.Latest,
        TabItem.Best,
        TabItem.Hot
    )
    val pagerState = rememberPagerState(tabs.size)
    Tabs(tabs = tabs, pagerState = pagerState)
}