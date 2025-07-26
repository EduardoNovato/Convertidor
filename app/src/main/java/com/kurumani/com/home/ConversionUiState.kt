package com.kurumani.com.home

data class ConversionUiState(
    val url: String = "",
    val selectedFormat: Format = Format.MP3,
    val isLoading: Boolean = false,
    val successMessage: String? = null,
    val errorMessage: String? = null
)
