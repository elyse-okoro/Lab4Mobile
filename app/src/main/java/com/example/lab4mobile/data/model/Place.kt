package com.example.lab4mobile.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/** Рекомендованное место: тексты в strings.xml, значок для списка и картинка для экрана деталей. */
data class Place(
    val id: Int,
    val categoryId: CategoryId,
    @param:StringRes val nameRes: Int,
    @param:StringRes val summaryRes: Int,
    @param:StringRes val descriptionRes: Int,
    @param:StringRes val addressRes: Int,
    @param:DrawableRes val iconRes: Int,
    @param:DrawableRes val imageRes: Int
)
