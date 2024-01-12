package com.gdsc.addi.ui.feature.splash

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gdsc.addi.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
    private val _loginState = MutableSharedFlow<LoginState>()
    val loginState = _loginState.asSharedFlow()

    fun checkUserState() = viewModelScope.launch {
        loginRepository.getLoginState()
            .onSuccess { response ->
                _loginState.emit(response)
                Log.d("asdf", response.name)
            }.onFailure { throwable ->
                Log.e("throwable", "$throwable")
            }
    }
}
