package com.gdsc.addi.data.repository

import com.gdsc.addi.data.service.AddiService
import com.gdsc.addi.data.source.LocalDataSource
import com.gdsc.addi.ui.feature.splash.LoginState
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val addiService: AddiService,
    private val localDataSource: LocalDataSource
) {
    suspend fun getLoginState(): Result<LoginState> =
        kotlin.runCatching { addiService.getLoginState() }.map { response ->
            LoginState.valueOf(response.role)
        }

    suspend fun postUserSignup(): Result<String> =
        kotlin.runCatching { addiService.postUserSignup() }.map { response ->
            response.invitationCode
        }

    fun setInviteCode(inviteCode: String) {
        localDataSource.inviteCode = inviteCode
    }

    fun getInviteCode() = localDataSource.inviteCode
}
