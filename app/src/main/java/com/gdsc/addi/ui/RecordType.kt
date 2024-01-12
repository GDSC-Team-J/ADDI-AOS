package com.gdsc.addi.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import com.gdsc.addi.R

enum class RecordType {
    USER,
    GUARDIAN,
    ;

    val title: String
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            USER -> stringResource(id = R.string.user_record_title)
            GUARDIAN -> stringResource(id = R.string.guardian_record_title)
        }
}
