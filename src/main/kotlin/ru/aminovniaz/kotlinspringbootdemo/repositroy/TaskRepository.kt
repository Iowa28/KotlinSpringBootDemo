package ru.aminovniaz.kotlinspringbootdemo.repositroy

import org.springframework.data.jpa.repository.JpaRepository
import ru.aminovniaz.kotlinspringbootdemo.model.Task

interface  TaskRepository : JpaRepository<Task, Long> {
    //fun findTasks(): List<Task>
}