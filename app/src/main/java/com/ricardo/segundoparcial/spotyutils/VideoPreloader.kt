package com.ricardo.segundoparcial.spotyutils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player.REPEAT_MODE_ALL
import com.google.android.exoplayer2.ui.StyledPlayerView


@SuppressLint("RememberReturnType")
@Composable
fun VideoPreloader(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    val mediaItem = MediaItem.Builder()
        .setUri("android.resource://${context.packageName}/raw/spotyentrance")
        .build()
    val exoPlayer = remember(context, mediaItem){
        ExoPlayer.Builder(context)
            .build()
            .also {
                exoPlayer ->
                exoPlayer.setMediaItem(mediaItem)
                exoPlayer.prepare()
                exoPlayer.playWhenReady = true
                exoPlayer.repeatMode = REPEAT_MODE_ALL
            }
    }

    DisposableEffect(
        AndroidView (factory = {
            StyledPlayerView(context).apply {
                player = exoPlayer
                layoutParams = android.widget.FrameLayout.LayoutParams(
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT,
                    android.widget.FrameLayout.LayoutParams.MATCH_PARENT
                )
                setPadding(0, 0, 0, 0)
            }
        })
    ){
        onDispose { exoPlayer.release() }
    }
}