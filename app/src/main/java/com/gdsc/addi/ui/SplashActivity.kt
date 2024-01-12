package com.gdsc.addi.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.gdsc.addi.ui.feature.splash.LoginState
import com.gdsc.addi.ui.feature.splash.SplashScreen
import com.gdsc.addi.ui.feature.splash.SplashViewModel
import com.gdsc.addi.ui.theme.AddiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                SplashScreen(
                    viewModel = splashViewModel,
                    onEvent = ::onEvent
                )
            }
        }
    }

    private fun onEvent(
        loginState: LoginState
    ) {
        when (loginState) {
            LoginState.NONE -> goToMain()
            LoginState.GUARDIAN -> goToGuardian()
            LoginState.USER -> goToGuardian()
        }
        finish()
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun goToGuardian() {
        startActivity(Intent(this, GuardianActivity::class.java))
        finish()
    }

    private fun goToUser() {
        startActivity(Intent(this, UserActivity::class.java))
        finish()
    }
}