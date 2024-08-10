package ec.edu.ups.toDoList.service

import ec.edu.ups.toDoList.dto.TaskDto

interface ITaskService {
    fun save(taskDto: TaskDto): TaskDto

    fun update(taskDto: TaskDto)

    fun getAll(idUser: Short): List<TaskDto>
}
