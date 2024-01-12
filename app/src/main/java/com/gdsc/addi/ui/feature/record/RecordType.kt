package com.gdsc.addi.ui.feature.record

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

    val done: String
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            USER -> stringResource(id = R.string.user_record_done_title)
            GUARDIAN -> stringResource(id = R.string.guardian_record_done_title)
        }

    val button: String
        @Composable
        @ReadOnlyComposable
        get() = when (this) {
            USER -> stringResource(id = R.string.user_record_next)
            GUARDIAN -> stringResource(id = R.string.guardian_record_submit)
        }
}
