package com.example.artspace.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
data class Artwork(
    @DrawableRes val artworkImage: Int,
    @StringRes val title: Int,
    @StringRes val artist: Int,
    val year: Int
)
