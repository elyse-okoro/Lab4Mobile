package com.example.lab4mobile.ui

import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.core.view.doOnLayout
import androidx.drawerlayout.widget.DrawerLayout

/**
 * Кнопка «Назад» при открытой боковой панели закрывает панель, а не уходит с экрана.
 * Включена только пока панель открыта.
 */
class CloseDrawerOnBackCallback(
    private val drawerLayout: DrawerLayout
) : OnBackPressedCallback(false), DrawerLayout.DrawerListener {

    init {
        // после поворота экрана панель восстанавливается открытой без вызова onDrawerOpened
        drawerLayout.doOnLayout { isEnabled = drawerLayout.isDrawerOpen(GravityCompat.START) }
    }

    override fun handleOnBackPressed() {
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onDrawerOpened(drawerView: View) {
        isEnabled = true
    }

    override fun onDrawerClosed(drawerView: View) {
        isEnabled = false
    }

    override fun onDrawerSlide(drawerView: View, slideOffset: Float) = Unit

    override fun onDrawerStateChanged(newState: Int) = Unit
}
