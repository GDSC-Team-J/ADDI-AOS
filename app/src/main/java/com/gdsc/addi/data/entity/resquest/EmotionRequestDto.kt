package com.gdsc.addi.data.entity.resquest

import kotlinx.serialization.Serializable

@Serializable
data class EmotionRequestDto(
    val inputs: String
)
