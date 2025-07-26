package com.kurumani.com.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF757575),           // App Bar
    onPrimary = Color.White,

    primaryContainer = Color(0xFFE0E0E0),   // Cards neutrales
    onPrimaryContainer = Color(0xFF212121),

    secondary = Color(0xFFBDBDBD),          // Gris medio
    onSecondary = Color(0xFF212121),

    background = Color(0xFFEEEEEE),         // Fondo general
    onBackground = Color(0xFF212121),

    surface = Color(0xFFFAFAFA),            // Cards/dialogs blancos
    onSurface = Color(0xFF212121),

    tertiary = Color(0xFF90CAF9),           // Azul suave para botones
    onTertiary = Color.Black
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9),            // Azul claro para acciones principales
    onPrimary = Color.Black,

    secondary = Color(0xFFB0BEC5),          // Gris claro útil para chips/botones secundarios
    onSecondary = Color.Black,

    background = Color(0xFF212121),         // Fondo general
    onBackground = Color(0xFFE0E0E0),       // Texto principal

    surface = Color(0xFF303030),            // Cards, app bar, dialog
    onSurface = Color(0xFFE0E0E0),          // Texto sobre surface

    primaryContainer = Color(0xFF424242),   // Variantes para tarjetas secundarias
    onPrimaryContainer = Color(0xFFF5F5F5), // Texto claro para container

    tertiary = Color(0xFFCE93D8),           // Accent suave
    onTertiary = Color(0xFF2C003E)
)



@Composable
fun ConvertidorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}