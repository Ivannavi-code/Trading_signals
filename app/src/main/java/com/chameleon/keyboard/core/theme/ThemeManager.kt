package com.chameleon.keyboard.core.theme

import android.content.Context

class ThemeManager(private val context: Context) {

    private val appThemeMap = mapOf(
        "com.whatsapp" to Theme.WhatsApp,
        "com.whatsapp.w4b" to Theme.WhatsApp,
        "com.instagram.android" to Theme.Instagram,
        "com.twitter.android" to Theme.Twitter,
        "com.google.android.youtube" to Theme.YouTube
    )

    fun getThemeForApp(packageName: String?): Theme {
        packageName ?: return Theme.Default
        
        if (isGamingApp(packageName)) {
            return Theme.Gaming
        }
        
        return appThemeMap[packageName] ?: Theme.Default
    }

    fun getDefaultTheme(): Theme {
        return Theme.Default
    }

    private fun isGamingApp(packageName: String): Boolean {
        val gamingPackages = listOf(
            "com.tencent.ig",
            "com.dts.freefireth",
            "com.activision.callofduty.shooter",
            "com.mobile.legends",
            "com.garena.game.kgvn"
        )
        return gamingPackages.contains(packageName)
    }

    fun getAllThemes(): List<Theme> {
        return listOf(
            Theme.Default,
            Theme.WhatsApp,
            Theme.Instagram,
            Theme.Twitter,
            Theme.YouTube,
            Theme.Gaming
        )
    }
}
