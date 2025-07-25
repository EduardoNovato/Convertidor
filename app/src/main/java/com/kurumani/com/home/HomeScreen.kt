package com.kurumani.com.home

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kurumani.com.ui.theme.ConvertidorTheme

data class Platform(val name: String, val icon: ImageVector)

object Platforms {
    val youtube = Platform("Youtube", Icons.Filled.PlayCircle)
    val tiktok = Platform("TikTok", Icons.Filled.MusicNote)
    val facebook = Platform("Facebook", Icons.Filled.Facebook)
    val all = listOf(youtube, tiktok, facebook)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onPlatformSelected: (Platform) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Conversor de Videos") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                text = "Selecciona la plataforma",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(bottom = 24.dp)
            )

            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(Platforms.all) { platform ->
                    PlatformCard(platform, onPlatformSelected)
                }
            }
        }
    }
}

@Composable
fun PlatformCard(platform: Platform, onPlatformSelected: (Platform) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable { onPlatformSelected(platform) },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = platform.icon,
                contentDescription = platform.name,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = platform.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeLightPreview() {
    ConvertidorTheme(darkTheme = false, dynamicColor = false) {
        HomeScreen {}
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeDarkPreview() {
    ConvertidorTheme(darkTheme = true, dynamicColor = false) {
        HomeScreen {}
    }
}