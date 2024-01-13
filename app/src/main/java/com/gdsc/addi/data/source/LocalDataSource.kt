package com.gdsc.addi.data.source

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val prefs: SharedPreferences
) {
    var inviteCode: String
        set(value) = prefs.edit { putString(INVITE_CODE, value) }
        get() = prefs.getString(INVITE_CODE, "") ?: ""

    companion object {
        private const val INVITE_CODE = "inviteCode"
    }
}