package com.kurumani.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.kurumani.com.home.HomeScreen
import com.kurumani.com.ui.theme.ConvertidorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConvertidorTheme {
                HomeScreen { }
            }
        }
    }
}
