package com.gdsc.addi.ui.feature.guardian

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsc.addi.data.repository.AddiRepository
import com.gdsc.addi.ui.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GuardianCodeViewModel @Inject constructor(
    private val addiRepository: AddiRepository
) : ViewModel() {
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun postGuardianSignup(inviteCode: String) = viewModelScope.launch {
        _uiEvent.emit(UiEvent.IDLE)
        addiRepository.postGuardianSignup(inviteCode)
            .onSuccess {
                _uiEvent.emit(UiEvent.SUCCESS)
            }.onFailure { throwable ->
                _uiEvent.emit(UiEvent.ERROR)
                Log.e("throwable", "$throwable")
            }
    }

}