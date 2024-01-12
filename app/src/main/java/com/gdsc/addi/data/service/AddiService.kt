package com.gdsc.addi.data.service

import com.gdsc.addi.data.entity.LoginResponseDto
import retrofit2.http.GET

interface AddiService {
    @GET("api/login")
    suspend fun getLoginState(): LoginResponseDto
}
