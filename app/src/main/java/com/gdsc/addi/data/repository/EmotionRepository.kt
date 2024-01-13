package com.gdsc.addi.data.repository

import com.gdsc.addi.data.entity.response.Emotion
import com.gdsc.addi.data.entity.resquest.EmotionRequestDto
import com.gdsc.addi.data.service.EmotionService
import javax.inject.Inject

class EmotionRepository @Inject constructor(
    private val emotionService: EmotionService
) {
    suspend fun postEmotion(inputs: String): Result<List<Emotion>> =
        kotlin.runCatching { emotionService.postEmotion(EmotionRequestDto(inputs)) }
            .map { response ->
                response.flatten().subList(0, 5)
            }
}
