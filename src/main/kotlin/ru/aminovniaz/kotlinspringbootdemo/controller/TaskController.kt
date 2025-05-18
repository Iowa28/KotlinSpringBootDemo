package ru.aminovniaz.kotlinspringbootdemo.controller

import org.springframework.web.bind.annotation.*
import ru.aminovniaz.kotlinspringbootdemo.dto.TaskDto
import ru.aminovniaz.kotlinspringbootdemo.service.TaskService

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getAllTasks(): List<TaskDto> = taskService.findTasks()

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): TaskDto = taskService.getTask(id)

    @PostMapping
    fun saveTask(@RequestBody taskDto: TaskDto) = taskService.saveTask(taskDto)

    @PutMapping
    fun updateTask(@RequestBody taskDto: TaskDto) = taskService.updateTask(taskDto)

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long) = taskService.deleteTask(id)
}