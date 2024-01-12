package com.gdsc.addi.ui.feature.enter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsc.addi.data.repository.AuthRepository
import com.gdsc.addi.ui.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EnterViewModel @Inject constructor(
    private val authRepository: AuthRepository,
) : ViewModel() {
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun postUserSignup() = viewModelScope.launch {
        _uiEvent.emit(UiEvent.IDLE)
        authRepository.postUserSignup()
            .onSuccess { response ->
                authRepository.setInviteCode(response)
                _uiEvent.emit(UiEvent.SUCCESS)
            }.onFailure { throwable ->
                _uiEvent.emit(UiEvent.ERROR)
                Log.e("throwable", "$throwable")
            }
    }

}