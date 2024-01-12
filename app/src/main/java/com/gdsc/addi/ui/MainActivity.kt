package com.gdsc.addi.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdsc.addi.ui.feature.enter.EnterScreen
import com.gdsc.addi.ui.theme.AddiTheme
import com.gdsc.addi.ui.utils.UiEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                EnterScreen(
                    onClickGuardianEnter = ::goToGuardian,
                    onClickUserEnter = ::onUserEvent,
                )
            }
        }
    }

    private fun onUserEvent(
        uiEvent: UiEvent
    ) {
        when (uiEvent) {
            UiEvent.IDLE -> {}
            UiEvent.SUCCESS -> goToUser()
            UiEvent.ERROR -> {}
        }
        finish()
    }

    private fun goToGuardian() {
        startActivity(Intent(this, GuardianActivity::class.java))
    }

    private fun goToUser() {
        startActivity(Intent(this, UserActivity::class.java))
    }
}
