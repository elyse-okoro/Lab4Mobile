package com.example.lab4mobile.data

import com.example.lab4mobile.fake.FakeSharedPreferences
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class FavoritesRepositoryTest {

    private val preferences = FakeSharedPreferences()

    @Test
    fun noFavoritesAtFirstLaunch() {
        assertTrue(FavoritesRepository(preferences).getFavoriteIds().isEmpty())
    }

    @Test
    fun toggle_addsAndRemovesPlace() {
        val repository = FavoritesRepository(preferences)

        assertEquals(setOf(6), repository.toggle(6))
        assertEquals(setOf(6, 12), repository.toggle(12))
        assertEquals(setOf(12), repository.toggle(6))
    }

    @Test
    fun favoritesSurviveAppRestart() {
        FavoritesRepository(preferences).toggle(18)

        assertEquals(setOf(18), FavoritesRepository(preferences).getFavoriteIds())
    }
}
