package com.dat.androidhmi.composetodolist.features.splash.ui

sealed class SplashEffect {
    object NavigateToDashboard : SplashEffect()
    object NavigateToLogin : SplashEffect()
}
