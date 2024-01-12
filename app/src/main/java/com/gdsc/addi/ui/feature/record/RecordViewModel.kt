package com.gdsc.addi.ui.feature.record

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsc.addi.data.repository.AddiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecordViewModel @Inject constructor(
    repository: AddiRepository
) : ViewModel() {
    private val _questions = MutableStateFlow<List<String>>(emptyList())
    val questions = _questions.asStateFlow()

    fun getQuestions() {
        viewModelScope.launch {
            _questions.value = listOf("question1", "question2", "question3")
        }
    }
}