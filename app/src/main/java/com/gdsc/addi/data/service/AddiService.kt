package com.gdsc.addi.data.service

import com.gdsc.addi.data.entity.response.LoginResponseDto
import com.gdsc.addi.data.entity.response.UserSignupResponseDto
import retrofit2.http.GET
import retrofit2.http.POST
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
}
