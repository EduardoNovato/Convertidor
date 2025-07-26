package com.kurumani.com.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ConversionViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ConversionUiState())
    val uiState: StateFlow<ConversionUiState> = _uiState.asStateFlow()

    fun onUrlChanged(newUrl: String) {
        _uiState.value = _uiState.value.copy(url = newUrl, successMessage = null, errorMessage = null)
    }

    fun onFormatSelected(format: Format) {
        _uiState.value = _uiState.value.copy(selectedFormat = format)
    }

    fun convert() {
        val url = _uiState.value.url
        if (url.isBlank()) {
            _uiState.value = _uiState.value.copy(errorMessage = "La URL no puede estar vacía.")
            return
        }

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null, successMessage = null)

            // Simulación de la conversión
            delay(2000)

            _uiState.value = _uiState.value.copy(
                isLoading = false,
                successMessage = "Conversión completada para ${_uiState.value.selectedFormat.name}"
            )
        }
    }
}