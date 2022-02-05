package com.example.rusin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rusin.ui.screens.MainScreen
import com.example.rusin.ui.theme.RusinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RusinTheme {
                MainScreen()
            }
        }
    }
}


@Composable
fun ScreenOne() {
    // todo
}

@Composable
fun ScreenTwo() {
    // todo
}

@Composable
fun ScreenThree() {
    // todo
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(12.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Rounded.AccountCircle,
            contentDescription = "User avatar",
            modifier = Modifier.size(40.dp),
            tint = Color.Gray
        )
        Text(
            text = "Developers Life",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RusinTheme {
        MainScreen()
    }
}