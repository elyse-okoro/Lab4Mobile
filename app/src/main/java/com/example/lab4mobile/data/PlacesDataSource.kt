package com.example.lab4mobile.data

import com.example.lab4mobile.R
import com.example.lab4mobile.data.model.Category
import com.example.lab4mobile.data.model.CategoryId
import com.example.lab4mobile.data.model.Place

/**
 * Категории и места Ижевска. Тексты — в strings.xml (ru и en), здесь только идентификаторы ресурсов.
 */
object PlacesDataSource {

    val categories: List<Category> = listOf(
        Category(
            id = CategoryId.SIGHTS,
            titleRes = R.string.category_sights_title,
            descriptionRes = R.string.category_sights_description,
            iconRes = R.drawable.ic_category_sights
        ),
        Category(
            id = CategoryId.MUSEUMS,
            titleRes = R.string.category_museums_title,
            descriptionRes = R.string.category_museums_description,
            iconRes = R.drawable.ic_category_museums
        ),
        Category(
            id = CategoryId.PARKS,
            titleRes = R.string.category_parks_title,
            descriptionRes = R.string.category_parks_description,
            iconRes = R.drawable.ic_category_parks
        ),
        Category(
            id = CategoryId.THEATRES,
            titleRes = R.string.category_theatres_title,
            descriptionRes = R.string.category_theatres_description,
            iconRes = R.drawable.ic_category_theatres
        ),
        Category(
            id = CategoryId.FAMILY,
            titleRes = R.string.category_family_title,
            descriptionRes = R.string.category_family_description,
            iconRes = R.drawable.ic_category_family
        )
    )

    val places: List<Place> = listOf(
        Place(
            id = 1,
            categoryId = CategoryId.SIGHTS,
            nameRes = R.string.place_sights_1_name,
            summaryRes = R.string.place_sights_1_summary,
            descriptionRes = R.string.place_sights_1_description,
            addressRes = R.string.place_sights_1_address,
            iconRes = R.drawable.ic_flag,
            imageRes = R.drawable.place_sights_1
        ),
        Place(
            id = 2,
            categoryId = CategoryId.SIGHTS,
            nameRes = R.string.place_sights_2_name,
            summaryRes = R.string.place_sights_2_summary,
            descriptionRes = R.string.place_sights_2_description,
            addressRes = R.string.place_sights_2_address,
            iconRes = R.drawable.ic_church,
            imageRes = R.drawable.place_sights_2
        ),
        Place(
            id = 3,
            categoryId = CategoryId.SIGHTS,
            nameRes = R.string.place_sights_3_name,
            summaryRes = R.string.place_sights_3_summary,
            descriptionRes = R.string.place_sights_3_description,
            addressRes = R.string.place_sights_3_address,
            iconRes = R.drawable.ic_factory,
            imageRes = R.drawable.place_sights_3
        ),
        Place(
            id = 4,
            categoryId = CategoryId.SIGHTS,
            nameRes = R.string.place_sights_4_name,
            summaryRes = R.string.place_sights_4_summary,
            descriptionRes = R.string.place_sights_4_description,
            addressRes = R.string.place_sights_4_address,
            iconRes = R.drawable.ic_church,
            imageRes = R.drawable.place_sights_4
        ),
        Place(
            id = 5,
            categoryId = CategoryId.SIGHTS,
            nameRes = R.string.place_sights_5_name,
            summaryRes = R.string.place_sights_5_summary,
            descriptionRes = R.string.place_sights_5_description,
            addressRes = R.string.place_sights_5_address,
            iconRes = R.drawable.ic_location_city,
            imageRes = R.drawable.place_sights_5
        ),
        Place(
            id = 6,
            categoryId = CategoryId.MUSEUMS,
            nameRes = R.string.place_museums_1_name,
            summaryRes = R.string.place_museums_1_summary,
            descriptionRes = R.string.place_museums_1_description,
            addressRes = R.string.place_museums_1_address,
            iconRes = R.drawable.ic_museum,
            imageRes = R.drawable.place_museums_1
        ),
        Place(
            id = 7,
            categoryId = CategoryId.MUSEUMS,
            nameRes = R.string.place_museums_2_name,
            summaryRes = R.string.place_museums_2_summary,
            descriptionRes = R.string.place_museums_2_description,
            addressRes = R.string.place_museums_2_address,
            iconRes = R.drawable.ic_account_balance,
            imageRes = R.drawable.place_museums_2
        ),
        Place(
            id = 8,
            categoryId = CategoryId.MUSEUMS,
            nameRes = R.string.place_museums_3_name,
            summaryRes = R.string.place_museums_3_summary,
            descriptionRes = R.string.place_museums_3_description,
            addressRes = R.string.place_museums_3_address,
            iconRes = R.drawable.ic_palette,
            imageRes = R.drawable.place_museums_3
        ),
        Place(
            id = 9,
            categoryId = CategoryId.MUSEUMS,
            nameRes = R.string.place_museums_4_name,
            summaryRes = R.string.place_museums_4_summary,
            descriptionRes = R.string.place_museums_4_description,
            addressRes = R.string.place_museums_4_address,
            iconRes = R.drawable.ic_cottage,
            imageRes = R.drawable.place_museums_4
        ),
        Place(
            id = 10,
            categoryId = CategoryId.MUSEUMS,
            nameRes = R.string.place_museums_5_name,
            summaryRes = R.string.place_museums_5_summary,
            descriptionRes = R.string.place_museums_5_description,
            addressRes = R.string.place_museums_5_address,
            iconRes = R.drawable.ic_two_wheeler,
            imageRes = R.drawable.place_museums_5
        ),
        Place(
            id = 11,
            categoryId = CategoryId.PARKS,
            nameRes = R.string.place_parks_1_name,
            summaryRes = R.string.place_parks_1_summary,
            descriptionRes = R.string.place_parks_1_description,
            addressRes = R.string.place_parks_1_address,
            iconRes = R.drawable.ic_waves,
            imageRes = R.drawable.place_parks_1
        ),
        Place(
            id = 12,
            categoryId = CategoryId.PARKS,
            nameRes = R.string.place_parks_2_name,
            summaryRes = R.string.place_parks_2_summary,
            descriptionRes = R.string.place_parks_2_description,
            addressRes = R.string.place_parks_2_address,
            iconRes = R.drawable.ic_park,
            imageRes = R.drawable.place_parks_2
        ),
        Place(
            id = 13,
            categoryId = CategoryId.PARKS,
            nameRes = R.string.place_parks_3_name,
            summaryRes = R.string.place_parks_3_summary,
            descriptionRes = R.string.place_parks_3_description,
            addressRes = R.string.place_parks_3_address,
            iconRes = R.drawable.ic_forest,
            imageRes = R.drawable.place_parks_3
        ),
        Place(
            id = 14,
            categoryId = CategoryId.PARKS,
            nameRes = R.string.place_parks_4_name,
            summaryRes = R.string.place_parks_4_summary,
            descriptionRes = R.string.place_parks_4_description,
            addressRes = R.string.place_parks_4_address,
            iconRes = R.drawable.ic_local_fire_department,
            imageRes = R.drawable.place_parks_4
        ),
        Place(
            id = 15,
            categoryId = CategoryId.PARKS,
            nameRes = R.string.place_parks_5_name,
            summaryRes = R.string.place_parks_5_summary,
            descriptionRes = R.string.place_parks_5_description,
            addressRes = R.string.place_parks_5_address,
            iconRes = R.drawable.ic_nature_people,
            imageRes = R.drawable.place_parks_5
        ),
        Place(
            id = 16,
            categoryId = CategoryId.THEATRES,
            nameRes = R.string.place_theatres_1_name,
            summaryRes = R.string.place_theatres_1_summary,
            descriptionRes = R.string.place_theatres_1_description,
            addressRes = R.string.place_theatres_1_address,
            iconRes = R.drawable.ic_theater_comedy,
            imageRes = R.drawable.place_theatres_1
        ),
        Place(
            id = 17,
            categoryId = CategoryId.THEATRES,
            nameRes = R.string.place_theatres_2_name,
            summaryRes = R.string.place_theatres_2_summary,
            descriptionRes = R.string.place_theatres_2_description,
            addressRes = R.string.place_theatres_2_address,
            iconRes = R.drawable.ic_local_activity,
            imageRes = R.drawable.place_theatres_2
        ),
        Place(
            id = 18,
            categoryId = CategoryId.THEATRES,
            nameRes = R.string.place_theatres_3_name,
            summaryRes = R.string.place_theatres_3_summary,
            descriptionRes = R.string.place_theatres_3_description,
            addressRes = R.string.place_theatres_3_address,
            iconRes = R.drawable.ic_theater_comedy,
            imageRes = R.drawable.place_theatres_3
        ),
        Place(
            id = 19,
            categoryId = CategoryId.THEATRES,
            nameRes = R.string.place_theatres_4_name,
            summaryRes = R.string.place_theatres_4_summary,
            descriptionRes = R.string.place_theatres_4_description,
            addressRes = R.string.place_theatres_4_address,
            iconRes = R.drawable.ic_child_care,
            imageRes = R.drawable.place_theatres_4
        ),
        Place(
            id = 20,
            categoryId = CategoryId.THEATRES,
            nameRes = R.string.place_theatres_5_name,
            summaryRes = R.string.place_theatres_5_summary,
            descriptionRes = R.string.place_theatres_5_description,
            addressRes = R.string.place_theatres_5_address,
            iconRes = R.drawable.ic_music_note,
            imageRes = R.drawable.place_theatres_5
        ),
        Place(
            id = 21,
            categoryId = CategoryId.FAMILY,
            nameRes = R.string.place_family_1_name,
            summaryRes = R.string.place_family_1_summary,
            descriptionRes = R.string.place_family_1_description,
            addressRes = R.string.place_family_1_address,
            iconRes = R.drawable.ic_pets,
            imageRes = R.drawable.place_family_1
        ),
        Place(
            id = 22,
            categoryId = CategoryId.FAMILY,
            nameRes = R.string.place_family_2_name,
            summaryRes = R.string.place_family_2_summary,
            descriptionRes = R.string.place_family_2_description,
            addressRes = R.string.place_family_2_address,
            iconRes = R.drawable.ic_festival,
            imageRes = R.drawable.place_family_2
        ),
        Place(
            id = 23,
            categoryId = CategoryId.FAMILY,
            nameRes = R.string.place_family_3_name,
            summaryRes = R.string.place_family_3_summary,
            descriptionRes = R.string.place_family_3_description,
            addressRes = R.string.place_family_3_address,
            iconRes = R.drawable.ic_attractions,
            imageRes = R.drawable.place_family_3
        ),
        Place(
            id = 24,
            categoryId = CategoryId.FAMILY,
            nameRes = R.string.place_family_4_name,
            summaryRes = R.string.place_family_4_summary,
            descriptionRes = R.string.place_family_4_description,
            addressRes = R.string.place_family_4_address,
            iconRes = R.drawable.ic_satellite_alt,
            imageRes = R.drawable.place_family_4
        ),
        Place(
            id = 25,
            categoryId = CategoryId.FAMILY,
            nameRes = R.string.place_family_5_name,
            summaryRes = R.string.place_family_5_summary,
            descriptionRes = R.string.place_family_5_description,
            addressRes = R.string.place_family_5_address,
            iconRes = R.drawable.ic_rocket_launch,
            imageRes = R.drawable.place_family_5
        )
    )
}
