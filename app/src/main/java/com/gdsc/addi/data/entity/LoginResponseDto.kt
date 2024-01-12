package com.gdsc.addi.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val role: String
)
