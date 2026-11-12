package com.example.lab4mobile.data

import android.content.SharedPreferences
import androidx.core.content.edit

/** Избранные места хранятся в SharedPreferences набором id. */
class FavoritesRepository(private val preferences: SharedPreferences) {

    fun getFavoriteIds(): Set<Int> =
        preferences.getStringSet(KEY_FAVORITES, emptySet()).orEmpty().mapNotNull { it.toIntOrNull() }.toSet()

    /** Добавляет место в избранное или убирает из него; возвращает новый набор. */
    fun toggle(placeId: Int): Set<Int> {
        val current = getFavoriteIds()
        val updated = if (placeId in current) current - placeId else current + placeId
        preferences.edit { putStringSet(KEY_FAVORITES, updated.map { it.toString() }.toSet()) }
        return updated
    }

    private companion object {
        const val KEY_FAVORITES = "favorite_place_ids"
    }
}
