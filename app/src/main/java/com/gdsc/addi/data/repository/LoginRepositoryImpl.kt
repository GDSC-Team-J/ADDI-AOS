package com.gdsc.addi.data.repository

import com.gdsc.addi.data.service.AddiService
import com.gdsc.addi.ui.feature.splash.LoginState
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val addiService: AddiService
) {
    suspend fun getLoginState(): Result<LoginState> =
        kotlin.runCatching { addiService.getLoginState() }.map { response ->
            LoginState.valueOf(response.role)
        }
}
