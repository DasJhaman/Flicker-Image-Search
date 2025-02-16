package com.sap

import androidx.compose.ui.window.ComposeUIViewController
import com.sap.di.initKoin
import com.sap.presentation.screen.MainContent

fun MainViewController() = ComposeUIViewController { MainContent() }

fun startKoin() = initKoin(emptyList())
