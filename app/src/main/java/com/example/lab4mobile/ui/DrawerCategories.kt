package com.example.lab4mobile.ui

import android.os.Bundle
import androidx.annotation.IdRes
import com.example.lab4mobile.R
import com.example.lab4mobile.data.model.CategoryId
import com.example.lab4mobile.ui.places.PlacesFragmentArgs

/** Пункты боковой панели, которые открывают список мест категории. */
object DrawerCategories {

    private val byMenuId: Map<Int, CategoryId> = mapOf(
        R.id.drawer_sights to CategoryId.SIGHTS,
        R.id.drawer_museums to CategoryId.MUSEUMS,
        R.id.drawer_parks to CategoryId.PARKS,
        R.id.drawer_theatres to CategoryId.THEATRES,
        R.id.drawer_family to CategoryId.FAMILY
    )

    fun categoryFor(@IdRes menuItemId: Int): CategoryId? = byMenuId[menuItemId]

    @IdRes
    fun menuItemFor(categoryId: CategoryId): Int = byMenuId.entries.first { it.value == categoryId }.key

    /** Какой пункт панели выделить на экране [destinationId]; null — ни один. */
    fun checkedItemFor(@IdRes destinationId: Int, arguments: Bundle?): Int? = when (destinationId) {
        R.id.placesFragment -> arguments?.let { menuItemFor(PlacesFragmentArgs.fromBundle(it).categoryId) }
        R.id.aboutFragment, R.id.settingsFragment -> destinationId
        else -> null
    }
}
