package com.example.lab4mobile.data

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.lab4mobile.data.model.ThemeMode

class SettingsRepository(private val preferences: SharedPreferences) {

    fun getThemeMode(): ThemeMode {
        val saved = preferences.getString(KEY_THEME, null)
        return ThemeMode.entries.firstOrNull { it.name == saved } ?: ThemeMode.SYSTEM
    }

    fun setThemeMode(mode: ThemeMode) {
        preferences.edit { putString(KEY_THEME, mode.name) }
    }

    private companion object {
        const val KEY_THEME = "theme_mode"
    }
}
