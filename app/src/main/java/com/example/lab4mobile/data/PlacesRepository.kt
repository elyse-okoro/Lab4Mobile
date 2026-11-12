package com.example.lab4mobile.data

import com.example.lab4mobile.data.model.Category
import com.example.lab4mobile.data.model.CategoryId
import com.example.lab4mobile.data.model.Place

/**
 * Доступ к категориям и местам. Экраны получают данные только через ViewModel.
 */
class PlacesRepository(
    private val categories: List<Category> = PlacesDataSource.categories,
    private val places: List<Place> = PlacesDataSource.places
) {

    fun getCategories(): List<Category> = categories

    fun getCategory(id: CategoryId): Category = categories.first { it.id == id }

    fun getPlaces(categoryId: CategoryId): List<Place> = places.filter { it.categoryId == categoryId }

    fun getPlaces(ids: Set<Int>): List<Place> = places.filter { it.id in ids }

    fun getPlace(id: Int): Place? = places.firstOrNull { it.id == id }

    /** Для главного экрана — первое место каждой категории. */
    fun getFeaturedPlaces(): List<Place> =
        categories.mapNotNull { category -> places.firstOrNull { it.categoryId == category.id } }
}
