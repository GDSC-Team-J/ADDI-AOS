package com.gdsc.addi.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdsc.addi.ui.feature.user.UserHome
import com.gdsc.addi.ui.theme.AddiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                UserHome()
            }
        }
    }
}
