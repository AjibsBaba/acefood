package com.ajibsbaba.acefood

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "onboarding_pref")

object OnboardingManager {
    private val KEY_ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")


    fun onboardingCompleted(context: Context): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[KEY_ONBOARDING_COMPLETED] ?: false
        }
    }


    suspend fun setOnboardingCompleted(context: Context) {
        context.dataStore.edit { preferences ->
            preferences[KEY_ONBOARDING_COMPLETED] = true
        }
    }

}