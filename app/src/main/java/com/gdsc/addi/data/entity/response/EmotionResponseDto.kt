package com.gdsc.addi.data.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class EmotionResponseDto(
    val emotions: List<Emotion>
)
