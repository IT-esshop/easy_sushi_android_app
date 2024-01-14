package com.example.easysushi.core

sealed class DataState<T> {
    data class Loading<T>(val isLoading: Boolean): DataState<T>()
    data class Success<T>(val data: T): DataState<T>()
    data class Error<T>(val uiComponent: UiComponent): DataState<T>()
}

sealed class UiComponent {

    data class Toast(val text: String): UiComponent()
    data class Dialog(val title: String, val message: String): UiComponent()

}
