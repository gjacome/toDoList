package ec.edu.ups.toDoList.mapper

import ec.edu.ups.toDoList.dto.TaskDto
import ec.edu.ups.toDoList.entity.TaskEntity

object TaskMapper {
    fun buildDtoFromEntity(entity: TaskEntity): TaskDto =
        TaskDto(
            id = entity.id,
            idUser = entity.idUser,
            description = entity.description,
            status = entity.status
        )

    fun buildEntityFromDto(dto: TaskDto): TaskEntity =
        TaskEntity(
            id = dto.id,
            idUser = dto.idUser,
            description = dto.description,
            status = dto.status
        )
}
