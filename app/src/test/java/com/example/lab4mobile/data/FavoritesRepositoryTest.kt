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

        assertEquals(setOf("museums_1"), repository.toggle("museums_1"))
        assertEquals(setOf("museums_1", "parks_2"), repository.toggle("parks_2"))
        assertEquals(setOf("parks_2"), repository.toggle("museums_1"))
    }

    @Test
    fun favoritesSurviveAppRestart() {
        FavoritesRepository(preferences).toggle("theatres_3")

        assertEquals(setOf("theatres_3"), FavoritesRepository(preferences).getFavoriteIds())
    }
}
