package com.gdsc.addi.ui.feature.record

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsc.addi.data.repository.AddiRepository
import com.gdsc.addi.data.repository.EmotionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
    private val addiRepository: AddiRepository,
    private val emotionRepository: EmotionRepository
) : ViewModel() {
    private val _questions = MutableStateFlow<List<String>>(emptyList())
    val questions = _questions.asStateFlow()

    private val records = MutableStateFlow<List<Uri>>(emptyList())

    fun addRecord(record: Uri) {
        val updatedRecords = records.value.toMutableList().apply {
            add(record)
        }
        records.value = updatedRecords
    }

//    fun postRecord() {
//        viewModelScope.launch {
//            emotionRepository.postEmotion("I am not having a great day.")
//                .onSuccess {
//                    Log.d("asdf", "$it")
//                }.onFailure {
//                    throw it
//                }
//        }
//    }

//    fun postRecord() {
//        Log.d("asdf", "버튼 눌림눌림")
//        viewModelScope.launch {
//            addiRepository.postRecord(records.value)
//                .onSuccess { text ->
//                    emotionRepository.postEmotion(text)
//                }.onFailure {
//                    throw it
//                }
//        }
//    }

    fun getQuestions() {
        viewModelScope.launch {
            _questions.value = listOf(
                "요새 소외감을 느끼실 때가 있으신가요?",
                "요새 걱정하시는게 있으신가요?",
                "현재 건강상태는 어떠세요?",
                "요새 즐거우신 일이 많으신가요?",
                "최근에 재미있는 일을 소개해주세요."
            )
        }
    }
}