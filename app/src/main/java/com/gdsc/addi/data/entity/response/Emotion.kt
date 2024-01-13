package com.gdsc.addi.data.entity.response

import kotlinx.serialization.Serializable

@Serializable
data class Emotion(
    val label: String,
    val score: Double
)