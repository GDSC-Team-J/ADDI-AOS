package com.gdsc.addi.data.repository

import android.content.Context
import android.net.Uri
import com.gdsc.addi.data.service.AddiService
import com.gdsc.addi.data.source.LocalDataSource
import com.gdsc.addi.ui.feature.splash.LoginState
import com.gdsc.addi.ui.utils.MultipartExt
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AddiRepository @Inject constructor(
    @ApplicationContext private val context: Context,
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

    suspend fun postGuardianSignup(inviteCode: String): Result<Unit> =
        kotlin.runCatching { addiService.postGuardianSignup(inviteCode) }

    suspend fun postRecord(
        files: List<Uri>,
    ): Result<String> =
        kotlin.runCatching {
            val fileBody = files.map { file ->
                MultipartExt.convertToMultiPartFile(file)
            }
            addiService.postRecord(fileBody)
        }.map { response ->
            response?.text ?: ""
        }


    fun setInviteCode(inviteCode: String) {
        localDataSource.inviteCode = inviteCode
    }

    fun getInviteCode() = localDataSource.inviteCode
}
