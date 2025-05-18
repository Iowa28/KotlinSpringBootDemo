package ru.aminovniaz.kotlinspringbootdemo.dto

import java.time.LocalDateTime

data class TaskDto (
    val id: Long? = null,

    var title: String,

    var description: String? = null,

    var completed: Boolean = false,

    val createdAt: LocalDateTime = LocalDateTime.now()
)