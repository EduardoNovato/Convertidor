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
    primary = Color(0xFF1E88E5),           // Azul limpio y brillante
    onPrimary = Color.White,
    secondary = Color(0xFF546E7A),         // Gris azulado sobrio
    onSecondary = Color.White,
    background = Color(0xFFF4F6F8),        // Gris claro (no blanco puro)
    onBackground = Color(0xFF1A1A1A),
    surface = Color.White,
    onSurface = Color(0xFF1A1A1A),
    primaryContainer = Color(0xFFE3F2FD),  // Azul muy claro para tarjetas
    onPrimaryContainer = Color(0xFF0D47A1),
    tertiary = Color(0xFF7E57C2),
    onTertiary = Color.White
)

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9),           // Azul claro visible
    onPrimary = Color(0xFF0D47A1),
    secondary = Color(0xFFB0BEC5),
    onSecondary = Color(0xFF263238),
    background = Color(0xFF121212),
    onBackground = Color(0xFFE0E0E0),
    surface = Color(0xFF1E1E1E),
    onSurface = Color(0xFFE0E0E0),
    primaryContainer = Color(0xFF2C2C2C),  // Gris carbón para tarjetas
    onPrimaryContainer = Color(0xFFBBDEFB),
    tertiary = Color(0xFFCE93D8),
    onTertiary = Color(0xFF4A148C)
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