package ru.aminovniaz.kotlinspringbootdemo.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.GenerationType
import java.time.LocalDateTime

@Entity
data class Task (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var title: String,

    var description: String? = null,

    var completed: Boolean = false,

    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    constructor(title: String, description: String?, completed: Boolean) : this(null, title, description, completed)
}