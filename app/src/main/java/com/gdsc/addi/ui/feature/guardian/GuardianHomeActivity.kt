package com.gdsc.addi.ui.feature.guardian

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.gdsc.addi.ui.theme.AddiTheme

class GuardianHomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AddiTheme {
                GuardianHome(
//                    onClickEnter = { /** 서버통신 */ }
                )
            }
        }
    }
}