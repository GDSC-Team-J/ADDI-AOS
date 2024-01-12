package com.gdsc.addi.ui.feature.user

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdsc.addi.ui.feature.record.RecordActivity
import com.gdsc.addi.ui.theme.AddiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                UserHome(onClickRecord = ::onClickRecord)
            }
        }
    }

    private fun onClickRecord() {
        startActivity(Intent(this, RecordActivity::class.java).putExtra(LOCATION, USER))
    }

    companion object {
        const val LOCATION = "location"
        const val USER = "user"
    }
}
