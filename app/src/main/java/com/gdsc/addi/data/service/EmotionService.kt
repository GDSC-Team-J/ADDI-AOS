package com.gdsc.addi.data.service

import com.gdsc.addi.data.entity.response.Emotion
import com.gdsc.addi.data.entity.response.EmotionResponseDto
import com.gdsc.addi.data.entity.resquest.EmotionRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface EmotionService {
    @POST("roberta-base-go_emotions")
    suspend fun postEmotion(
        @Body body: EmotionRequestDto
    ): List<List<Emotion>>
}