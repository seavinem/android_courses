package com.example.recipes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Meal(
    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val recipeRes: Int,
)