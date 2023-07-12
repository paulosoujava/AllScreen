package com.paulo.patterndesigns.ui.factory

import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import com.paulo.patterndesigns.ui.fabricSize.compact.BuildCompactScreen
import com.paulo.patterndesigns.ui.fabricSize.expanded.BuildExpandedScreen
import com.paulo.patterndesigns.ui.fabricSize.medium.BuildMediumScreen

@Composable
fun FactoryScreen(
    windowSizeClass:WindowSizeClass
) {
    when (windowSizeClass.widthSizeClass)  {
        WindowWidthSizeClass.Compact -> {
            BuildCompactScreen()
        }
        WindowWidthSizeClass.Medium -> {
           BuildMediumScreen()
        }
        WindowWidthSizeClass.Expanded -> {
            BuildExpandedScreen()
        }
    }
}
