package com.gdsc.addi.ui.feature.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsc.addi.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _loginState = MutableSharedFlow<LoginState>()
    val loginState = _loginState.asSharedFlow()

    fun checkUserState() = viewModelScope.launch {
        authRepository.getLoginState()
            .onSuccess { response ->
                _loginState.emit(response)
            }.onFailure { throwable ->
                Log.e("throwable", "$throwable")
            }
    }
}
