package com.example.app30days.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Day(
    val number: Int,
    val title: String,
    val description: String,
    var completed: Boolean = false
) {
    var isChecked by mutableStateOf(completed)
}

val days = List(30) { i ->
    Day(
        number = i + 1,
        title = "День ${i + 1}",
        description = "Упражнение или урок на день ${i + 1}"
    )
}
