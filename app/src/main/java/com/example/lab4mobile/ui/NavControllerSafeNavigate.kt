package com.example.lab4mobile.ui

import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections

/**
 * Переход только с того экрана, на котором нажали. Если нажать на две карточки сразу, второй переход
 * пришёл бы уже с нового экрана, где такого действия нет, и приложение упало бы.
 */
fun NavController.navigateFrom(@IdRes sourceId: Int, directions: NavDirections) {
    if (currentDestination?.id == sourceId) navigate(directions)
}
