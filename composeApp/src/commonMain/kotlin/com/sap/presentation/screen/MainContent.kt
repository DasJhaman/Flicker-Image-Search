package com.sap.presentation.screen

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sap.presentation.navigation.MainComposable
import com.sap.presentation.theme.FlickerImageSearchAppTheme

@Composable
fun MainContent() {
    val navController: NavHostController = rememberNavController()
    FlickerImageSearchAppTheme {
        MainComposable(navController = navController)
    }
}