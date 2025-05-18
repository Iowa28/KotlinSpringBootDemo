package ru.aminovniaz.kotlinspringbootdemo.service

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import ru.aminovniaz.kotlinspringbootdemo.dto.TaskDto
import ru.aminovniaz.kotlinspringbootdemo.model.Task
import ru.aminovniaz.kotlinspringbootdemo.repositroy.TaskRepository

@Service
class TaskServiceImpl(
    private val taskRepository: TaskRepository
) : TaskService {

    override fun findTasks(): List<TaskDto> {
        return taskRepository.findAll().map { toDto(it) }
    }

    override fun getTask(id: Long): TaskDto {
        val task = taskRepository.findById(id).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
        }
        return toDto(task)
    }

    override fun saveTask(taskDto: TaskDto) {
        val task = Task(taskDto.title, taskDto.description, taskDto.completed)
        taskRepository.save(task)
    }

    override fun updateTask(taskDto: TaskDto) {
        val task = taskRepository.findById(taskDto.id!!).orElseThrow {
            ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
        }
        task.title = taskDto.title
        task.description = taskDto.description
        task.completed = taskDto.completed
        taskRepository.save(task)
    }

    override fun deleteTask(id: Long) {
        taskRepository.deleteById(id)
    }

    private fun toDto(task: Task): TaskDto {
        return TaskDto(task.id, task.title, task.description, task.completed, task.createdAt)
    }
}