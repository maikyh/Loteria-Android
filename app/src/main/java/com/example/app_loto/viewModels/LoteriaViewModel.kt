package com.example.app_loto.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoteriaViewModel : ViewModel() {
    private val _lotoNumbers = mutableStateOf(emptyList<Int>())
    val lotoNumbers: State<List<Int>> = _lotoNumbers

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun generateLotoNumbers() {
        _lotoNumbers.value = emptyList()
        viewModelScope.launch {
            _isLoading.value = true
            for(number in (1..60).shuffled().take(6).sorted()) {
                delay(1000)
                _lotoNumbers.value = _lotoNumbers.value + number
            }
            _isLoading.value = false
        }
    }
}
