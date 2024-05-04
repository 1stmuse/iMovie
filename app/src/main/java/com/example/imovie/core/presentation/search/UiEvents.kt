package com.example.imovie.core.presentation.search

sealed class UiEvents {
    class OnChange(val searchTerm: String): UiEvents()
}