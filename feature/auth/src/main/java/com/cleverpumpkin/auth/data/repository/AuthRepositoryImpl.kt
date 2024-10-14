package com.cleverpumpkin.auth.data.repository

import android.content.SharedPreferences
import com.cleverpumpkin.auth.repository.AuthRepository
import com.cleverpumpkin.core.data.preference.PreferenceKeys
import javax.inject.Inject

/**
 * Implementation of [AuthRepository] using SharedPreferences for authentication.
 */

class AuthRepositoryImpl @Inject constructor(private val prefs: SharedPreferences) :
    AuthRepository {

    override fun yandexAuth(yandexToken: String) {
        prefs.edit().putString(PreferenceKeys.AUTH_KEY, "OAuth $yandexToken").apply()
        //TODO post token
    }

    override fun getToken(): String {
        return prefs.getString(PreferenceKeys.AUTH_KEY, "")
            ?: ""
    }

    override fun canLogin(): Boolean {
        return prefs.contains(PreferenceKeys.AUTH_KEY)
    }
}
