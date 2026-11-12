package com.example.lab4mobile.data

import android.content.SharedPreferences
import androidx.core.content.edit

/** Избранные места хранятся в SharedPreferences набором id. */
class FavoritesRepository(private val preferences: SharedPreferences) {

    fun getFavoriteIds(): Set<String> =
        preferences.getStringSet(KEY_FAVORITES, emptySet()).orEmpty().toSet()

    /** Добавляет место в избранное или убирает из него; возвращает новый набор. */
    fun toggle(placeId: String): Set<String> {
        val current = getFavoriteIds()
        val updated = if (placeId in current) current - placeId else current + placeId
        preferences.edit { putStringSet(KEY_FAVORITES, updated) }
        return updated
    }

    private companion object {
        const val KEY_FAVORITES = "favorite_place_ids"
    }
}
