package com.gdsc.addi.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdsc.addi.ui.feature.enter.EnterScreen
import com.gdsc.addi.ui.theme.AddiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                EnterScreen(
                    onClickGuardianEnter = ::goToGuardian,
                    onClickUserEnter = ::goToUser
                )
            }
        }
    }

    private fun goToGuardian() {
        startActivity(Intent(this, GuardianActivity::class.java))
    }

    private fun goToUser() {
        startActivity(Intent(this, UserActivity::class.java))
    }
}
