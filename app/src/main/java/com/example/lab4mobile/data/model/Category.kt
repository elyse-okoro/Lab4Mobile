package com.example.lab4mobile.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: CategoryId,
    @param:StringRes val titleRes: Int,
    @param:StringRes val descriptionRes: Int,
    @param:DrawableRes val iconRes: Int
)
