package com.dat.androidhmi.composetodolist.features.localized.setting.data

import com.dat.androidhmi.composetodolist.model.Language
import kotlinx.coroutines.flow.Flow

interface ILocalizedSettingEnvironment {
    fun getLanguage(): Flow<Language>
    suspend fun setLanguage(language: Language)
}

