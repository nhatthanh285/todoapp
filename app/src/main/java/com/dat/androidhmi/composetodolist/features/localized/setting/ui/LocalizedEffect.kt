package com.dat.androidhmi.composetodolist.features.localized.setting.ui

import com.dat.androidhmi.composetodolist.model.Language

sealed class LocalizedEffect {
    data class ApplyLanguage(val language: Language) : LocalizedEffect()
}
