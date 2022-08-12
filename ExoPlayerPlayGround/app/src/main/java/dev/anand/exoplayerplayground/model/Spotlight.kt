package dev.anand.exoplayerplayground.model

import android.net.Uri

data class Spotlight(
    val id: Int,
    private val video: String,
    val userImage: String,
    val userName: String,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val comment: String,
    val commentsCount: Int
) {
    fun getVideoUrl(): Uri {
        return Uri.parse(video)
    }
}
