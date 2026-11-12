package com.example.lab4mobile.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.lab4mobile.data.FavoritesRepository
import com.example.lab4mobile.data.PlacesRepository
import com.example.lab4mobile.data.SettingsRepository
import com.example.lab4mobile.data.model.Category
import com.example.lab4mobile.data.model.CategoryId
import com.example.lab4mobile.data.model.Place
import com.example.lab4mobile.data.model.ThemeMode

/**
 * Общая ViewModel всех экранов (activityViewModels): категории, места, избранное и тема.
 * Экраны не обращаются к репозиториям напрямую, только через неё.
 */
class CityViewModel(
    private val placesRepository: PlacesRepository,
    private val favoritesRepository: FavoritesRepository,
    private val settingsRepository: SettingsRepository
) : ViewModel() {

    val categories: List<Category> = placesRepository.getCategories()

    val featuredPlaces: List<Place> = placesRepository.getFeaturedPlaces()

    private val _favoriteIds = MutableLiveData(favoritesRepository.getFavoriteIds())
    val favoriteIds: LiveData<Set<Int>> = _favoriteIds

    val favoritePlaces: LiveData<List<Place>> = _favoriteIds.map { ids -> placesRepository.getPlaces(ids) }

    private val _themeMode = MutableLiveData(settingsRepository.getThemeMode())
    val themeMode: LiveData<ThemeMode> = _themeMode

    fun getCategory(id: CategoryId): Category = placesRepository.getCategory(id)

    fun getPlaces(categoryId: CategoryId): List<Place> = placesRepository.getPlaces(categoryId)

    fun getPlace(id: Int): Place? = placesRepository.getPlace(id)

    fun toggleFavorite(placeId: Int) {
        _favoriteIds.value = favoritesRepository.toggle(placeId)
    }

    fun setThemeMode(mode: ThemeMode) {
        if (mode == _themeMode.value) return
        settingsRepository.setThemeMode(mode)
        _themeMode.value = mode
    }
}
