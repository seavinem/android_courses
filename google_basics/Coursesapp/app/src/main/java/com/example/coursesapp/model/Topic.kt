package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameResourceId: Int,
    val number: Int,
    @DrawableRes val imageResourceId: Int
)
