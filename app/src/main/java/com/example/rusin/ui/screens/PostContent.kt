package com.example.rusin.ui.screens

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.rusin.domain.model.Post
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun PostContent(
    post: Post,
    index: Int,
    onPreviousPost: () -> Unit,
    onNextPost: () -> Unit,
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (postCard, title, controls) = createRefs()

        Card(
            modifier = modifier
                .constrainAs(postCard) {
                    top.linkTo(parent.top, margin = 12.dp)
                    bottom.linkTo(controls.top, margin = 12.dp)
                    height = Dimension.fillToConstraints
                },
            shape = RoundedCornerShape(12.dp),
            elevation = 4.dp
        ) {
            val context = LocalContext.current
            val imageLoader = ImageLoader.Builder(context)
                .componentRegistry {
                    if (Build.VERSION.SDK_INT >= 28) {
                        add(ImageDecoderDecoder(context))
                    } else {
                        add(GifDecoder())
                    }
                }
                .crossfade(true)
                .build()

            CoilImage(
                imageModel = post.url,
                imageLoader = { imageLoader },
//                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                },
                failure = {
                    Text(text = "image request failed")
                }
            )
        }

        Box(
            modifier = Modifier
                .constrainAs(title) {
                    bottom.linkTo(postCard.bottom)
                }
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.DarkGray
                        )
                    )
                )
                .padding(horizontal = 12.dp, vertical = 16.dp),
        ) {
            Text(
                text = post.description,
                style = TextStyle(color = Color.White, fontSize = 20.sp)
            )
        }

        Row(modifier = modifier
            .constrainAs(controls) {
                bottom.linkTo(parent.bottom, margin = 12.dp)
                centerHorizontallyTo(parent)
            }
        ) {
            IconButton(
                onClick = onPreviousPost,
                modifier = modifier
                    .padding(end = 8.dp)
                    .size(50.dp)
                    .clip(CircleShape)
                    .shadow(elevation = 8.dp, shape = CircleShape, clip = true)
                    .background(Color.White),
                enabled = index > 0
            ) {
                Icon(
                    imageVector = Icons.Filled.Refresh,
                    tint = Color.Red,
                    contentDescription = "вернуться к предыдущему посту",
                    modifier = modifier
                        .scale(scaleX = -1f, scaleY = 1f)
                        .fillMaxSize()
                        .padding(12.dp)
                )
            }
            IconButton(
                onClick = onNextPost,
                modifier = modifier
                    .padding(end = 8.dp)
                    .size(50.dp)
                    .clip(CircleShape)
                    .shadow(elevation = 8.dp, shape = CircleShape, clip = true)
                    .background(Color.White)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    tint = Color.Green,
                    contentDescription = "следующий пост",
                    modifier = modifier
                        .fillMaxSize()
                        .padding(12.dp)
                )
            }
        }
    }
}