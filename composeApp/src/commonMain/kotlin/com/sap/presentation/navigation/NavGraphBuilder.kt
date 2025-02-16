package com.sap.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.sap.presentation.dashboard.DashboardScreen

fun NavGraphBuilder.dashboardScreen() {
    composable(route = ScreenRoutes.DashboardScreenRoute) {
        DashboardScreen()
    }
}