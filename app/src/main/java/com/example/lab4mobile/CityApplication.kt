package com.example.lab4mobile

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import com.example.lab4mobile.data.FavoritesRepository
import com.example.lab4mobile.data.PlacesRepository
import com.example.lab4mobile.data.SettingsRepository
import com.example.lab4mobile.ui.toNightMode

class CityApplication : Application() {

    val placesRepository: PlacesRepository by lazy { PlacesRepository() }

    val favoritesRepository: FavoritesRepository by lazy {
        FavoritesRepository(getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE))
    }

    val settingsRepository: SettingsRepository by lazy {
        SettingsRepository(getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE))
    }

    override fun onCreate() {
        super.onCreate()
        // тему выбирает пользователь в настройках, применяем её до создания первого экрана
        AppCompatDelegate.setDefaultNightMode(settingsRepository.getThemeMode().toNightMode())
    }

    private companion object {
        const val PREFERENCES_NAME = "my_izhevsk"
    }
}
