package com.gdsc.addi.ui.feature.record

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdsc.addi.ui.feature.user.UserActivity
import com.gdsc.addi.ui.theme.AddiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecordDoneActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                RecordDone(onClick = ::goToHome)
            }
        }
    }

    private fun goToHome() {
        startActivity(Intent(this, UserActivity::class.java))
        finish()
    }
}