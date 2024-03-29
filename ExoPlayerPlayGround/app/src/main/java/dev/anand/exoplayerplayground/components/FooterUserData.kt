package dev.anand.exoplayerplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.GraphicEq
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import dev.anand.exoplayerplayground.model.Spotlight
import dev.anand.exoplayerplayground.ui.theme.ThemeColors

val horizontalPadding = 10.dp

@Composable
fun FooterUserData(spotlight: Spotlight, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier.height(28.dp).width(28.dp),
                contentAlignment = Alignment.Center
            ) {
                val painter = rememberImagePainter(
                    data = "https://avatars.githubusercontent.com/u/50791485?v=4",
                    builder = {
                        transformations(
                            CircleCropTransformation()
                        )
                    }
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "@${spotlight.userName}",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = Icons.Outlined.BookmarkBorder,
                contentDescription = "Bookmark"
            )
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = Icons.Outlined.Add,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(horizontalPadding))

        // Audio
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = ThemeColors.DARK_TRANSPARENT)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                imageVector = Icons.Outlined.GraphicEq,
                contentDescription = "Bookmark"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "@${spotlight.userName}'s Sound",
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}