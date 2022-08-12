package dev.anand.exoplayerplayground

import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DataSource
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import dev.anand.exoplayerplayground.model.Spotlight
import dev.anand.exoplayerplayground.ui.theme.ExoPlayerPlayGroundTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ExoPlayerPlayGroundTheme {
                // A surface container using the 'background' color from the theme
                spotlightScreen()

            }
        }
    }

    @Composable
    fun spotlightScreen() {
        val spotlights = DummySpotlightData.spotlight
        Box(
            Modifier
                .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
                .background(
                    Color.Black
                )
        ) {
            LazyColumn {
                items(spotlights.size) { index ->
                    Box(modifier = Modifier.fillParentMaxSize()) {
                        VideoPlayer(uri = spotlights[index].getVideoUrl())
                        Column(Modifier.align(Alignment.BottomStart)) {
                            SpotlightFooter(spotlights[index])
                            Divider()
                        }
                    }

                }
            }
        }
    }

    @Composable
    @androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
    fun VideoPlayer(uri: Uri) {

        val mContext = LocalContext.current

        val mExoPlayer = remember {

            ExoPlayer.Builder(mContext).build().apply {
                val defaultDataSourceFactory = DefaultDataSource.Factory(mContext)
                val dataSourceFactory: DataSource.Factory =
                    DefaultDataSource.Factory(mContext, defaultDataSourceFactory)
                val source = ProgressiveMediaSource.Factory(dataSourceFactory)
                    .createMediaSource(MediaItem.fromUri(uri))
                setMediaSource(source)
                prepare()

            }
        }

        mExoPlayer.playWhenReady = true
        mExoPlayer.videoScalingMode = C.VIDEO_SCALING_MODE_DEFAULT
        mExoPlayer.repeatMode = Player.REPEAT_MODE_ONE

        DisposableEffect(

            AndroidView(factory = { context ->
                PlayerView(context).apply {
                    hideController()
                    useController = false
                    resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM

                    player = mExoPlayer
                    layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)


                }
            }


            )) {
            onDispose { mExoPlayer.release() }
        }
    }

}

@Composable
fun SpotlightFooter(spotlight: Spotlight) {
    Row(
        Modifier.fillMaxWidth().padding(start = 18.dp, bottom = 18.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        FooterUserData(
            spotlight = spotlight, modifier = Modifier.weight(8f)
        )

        FooterUserAction(
            modifier = Modifier.weight(2f)
        )
    }
}

