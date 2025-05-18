package ru.aminovniaz.kotlinspringbootdemo.mapper

import org.mapstruct.Mapper
import ru.aminovniaz.kotlinspringbootdemo.dto.TaskDto
import ru.aminovniaz.kotlinspringbootdemo.model.Task

@Mapper(componentModel = "spring")
interface TaskMapper {
    fun toDto(task: Task): TaskDto
}