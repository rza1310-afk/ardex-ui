package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.EdexPreferencesRepository
import com.example.model.EdexUserPreferences
import com.example.ui.screens.EdexDashboardScreen
import com.example.ui.theme.EdexTheme
import com.example.ui.viewmodel.EdexViewModel

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge(
      statusBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT),
      navigationBarStyle = SystemBarStyle.dark(android.graphics.Color.TRANSPARENT),
    )
    setContent {
      val context = LocalContext.current
      val prefsRepo = remember(context) { EdexPreferencesRepository(context.applicationContext) }
      val cachedPrefs by
        prefsRepo.preferences.collectAsStateWithLifecycle(initialValue = EdexUserPreferences())
      EdexTheme(themeId = cachedPrefs.themeId) {
        val viewModel: EdexViewModel = viewModel()
        EdexDashboardScreen(viewModel = viewModel)
      }
    }
  }
}
