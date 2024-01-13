package com.gdsc.addi.ui.feature.guardian

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdsc.addi.ui.theme.AddiTheme
import com.gdsc.addi.ui.utils.UiEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuardianCodeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                GuardianCodeScreen(
                    onEvent = ::onEvent
                )
            }
        }
    }

    private fun onEvent(
        uiEvent: UiEvent
    ) {
        when (uiEvent) {
            UiEvent.IDLE -> {}
            UiEvent.SUCCESS -> goToGuardianHome()
            UiEvent.ERROR -> {}
        }
    }

    private fun goToGuardianHome() {
        startActivity(Intent(this, GuardianHomeActivity::class.java))
        finish()
    }

}
