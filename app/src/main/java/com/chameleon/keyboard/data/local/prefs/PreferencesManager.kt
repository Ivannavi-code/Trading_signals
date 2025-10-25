package com.chameleon.keyboard.data.local.prefs

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(
        "chameleon_prefs",
        Context.MODE_PRIVATE
    )

    fun getTransparency(): Float {
        return prefs.getFloat("transparency", 0.8f)
    }

    fun setTransparency(value: Float) {
        prefs.edit().putFloat("transparency", value).apply()
    }

    fun getKeyboardMode(): String {
        return prefs.getString("keyboard_mode", "NORMAL") ?: "NORMAL"
    }

    fun setKeyboardMode(mode: String) {
        prefs.edit().putString("keyboard_mode", mode).apply()
    }

    fun isHapticEnabled(): Boolean {
        return prefs.getBoolean("haptic_enabled", true)
    }

    fun setHapticEnabled(enabled: Boolean) {
        prefs.edit().putBoolean("haptic_enabled", enabled).apply()
    }

    fun isSoundEnabled(): Boolean {
        return prefs.getBoolean("sound_enabled", false)
    }

    fun setSoundEnabled(enabled: Boolean) {
        prefs.edit().putBoolean("sound_enabled", enabled).apply()
    }
}
