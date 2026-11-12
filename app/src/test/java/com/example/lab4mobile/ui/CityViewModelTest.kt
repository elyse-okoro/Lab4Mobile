package com.example.lab4mobile.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.lab4mobile.data.FavoritesRepository
import com.example.lab4mobile.data.PlacesRepository
import com.example.lab4mobile.data.SettingsRepository
import com.example.lab4mobile.data.model.CategoryId
import com.example.lab4mobile.data.model.Place
import com.example.lab4mobile.data.model.ThemeMode
import com.example.lab4mobile.fake.FakeSharedPreferences
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class CityViewModelTest {

    /** LiveData обновляется сразу, без главного потока Android. */
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val preferences = FakeSharedPreferences()
    private val placesRepository = PlacesRepository()

    private fun createViewModel() = CityViewModel(
        placesRepository,
        FavoritesRepository(preferences),
        SettingsRepository(preferences)
    )

    @Test
    fun toggleFavorite_updatesFavoritePlaces() {
        val viewModel = createViewModel()
        val museum = placesRepository.getPlaces(CategoryId.MUSEUMS).first()
        val shown = mutableListOf<List<Place>>()
        viewModel.favoritePlaces.observeForever { places -> shown += places }

        viewModel.toggleFavorite(museum.id)
        viewModel.toggleFavorite(museum.id)

        assertEquals(listOf(emptyList(), listOf(museum), emptyList()), shown)
    }

    @Test
    fun favoritesAreRestoredAfterRestart() {
        val park = placesRepository.getPlaces(CategoryId.PARKS)[1]
        createViewModel().toggleFavorite(park.id)

        val restored = createViewModel()

        assertEquals(setOf(park.id), restored.favoriteIds.value)
    }

    @Test
    fun themeMode_followsSystemUntilUserChoosesAnother() {
        assertEquals(ThemeMode.SYSTEM, createViewModel().themeMode.value)

        createViewModel().setThemeMode(ThemeMode.DARK)

        assertEquals(ThemeMode.DARK, createViewModel().themeMode.value)
    }

    @Test
    fun placesOfCategory_comeInCatalogOrder() {
        val viewModel = createViewModel()

        val theatres = viewModel.getPlaces(CategoryId.THEATRES)

        assertEquals(placesRepository.getPlaces(CategoryId.THEATRES), theatres)
        assertEquals(CategoryId.THEATRES, viewModel.getCategory(CategoryId.THEATRES).id)
    }
}
