package com.example.lab4mobile.data

import com.example.lab4mobile.data.model.CategoryId
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class PlacesRepositoryTest {

    private val repository = PlacesRepository()

    @Test
    fun everyCategoryHasFivePlaces() {
        val categories = repository.getCategories()

        assertEquals(CategoryId.entries.toList(), categories.map { it.id })
        categories.forEach { category ->
            assertEquals(5, repository.getPlaces(category.id).size)
        }
    }

    @Test
    fun everyPlaceHasItsOwnIdTextsAndImage() {
        val places = CategoryId.entries.flatMap { repository.getPlaces(it) }

        assertEquals(25, places.map { it.id }.toSet().size)
        assertEquals(25, places.map { it.nameRes }.toSet().size)
        assertEquals(25, places.map { it.descriptionRes }.toSet().size)
        assertEquals(25, places.map { it.addressRes }.toSet().size)
        assertEquals(25, places.map { it.imageRes }.toSet().size)
    }

    @Test
    fun featuredPlaces_oneFromEachCategoryInMenuOrder() {
        val featured = repository.getFeaturedPlaces()

        assertEquals(CategoryId.entries.toList(), featured.map { it.categoryId })
    }

    @Test
    fun getPlace_findsById() {
        val park = repository.getPlaces(CategoryId.PARKS).first()

        assertEquals(park, repository.getPlace(park.id))
        assertNull(repository.getPlace("unknown"))
    }

    @Test
    fun getPlacesByIds_keepsCatalogOrder() {
        val sights = repository.getPlaces(CategoryId.SIGHTS)

        val found = repository.getPlaces(setOf(sights[2].id, sights[0].id))

        assertEquals(listOf(sights[0], sights[2]), found)
    }
}
