package com.example.easysushi.core

sealed interface Event {
    data class Snackbar(
        val message: String
    ) : Event
}
