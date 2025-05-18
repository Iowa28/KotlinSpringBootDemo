package ru.aminovniaz.kotlinspringbootdemo.service

import ru.aminovniaz.kotlinspringbootdemo.dto.TaskDto

interface TaskService {
    fun findTasks(): List<TaskDto>

    fun getTask(id: Long): TaskDto

    fun saveTask(taskDto: TaskDto)

    fun updateTask(taskDto: TaskDto)

    fun deleteTask(id: Long)
}