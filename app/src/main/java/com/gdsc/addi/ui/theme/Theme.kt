package com.gdsc.addi.ui.theme

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LocalColors = staticCompositionLocalOf {
    addiDefaultColorScheme()
}

private val LocalTypography = staticCompositionLocalOf {
    addiTypography()
}

object AddiDesignSystem {
    val colors: AddiColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: AddiTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}

@Composable
fun AddiTheme(
    darkTheme: Boolean = false,
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    colorScheme: AddiColorScheme = AddiDesignSystem.colors,
    typography: AddiTypography = AddiDesignSystem.typography,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            /** 상태바 색상 */
            window.statusBarColor = colorScheme.backgroundGreen.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(
        LocalColors provides colorScheme,
        LocalTypography provides typography
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = with(Modifier) {
                    fillMaxSize().background(AddiDesignSystem.colors.backgroundGreen)
                }
            ) {
                content()
            }
        }
    }
}