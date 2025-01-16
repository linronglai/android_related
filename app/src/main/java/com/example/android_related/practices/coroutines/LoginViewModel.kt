package com.example.android_related.practices.coroutines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {
    fun login(useName: String, password: String) {
        viewModelScope.launch {
            loginRepository.makeRequest()
        }
    }
}