package com.gdsc.addi.data.service

import com.gdsc.addi.data.entity.response.LoginResponseDto
import com.gdsc.addi.data.entity.response.RecordResponseDto
import com.gdsc.addi.data.entity.response.UserSignupResponseDto
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

interface AddiService {
    @GET("api/login")
    suspend fun getLoginState(): LoginResponseDto

    @POST("api/signup/user")
    suspend fun postUserSignup(): UserSignupResponseDto

    @POST("api/signup/guardian")
    suspend fun postGuardianSignup(
        @Query("invitationCode") inviteCode: String
    )

    @POST("api/uploadVoice")
    @Multipart
    suspend fun postRecord(
        @Part files: List<MultipartBody.Part>,
    ): RecordResponseDto?
}
