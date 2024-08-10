package ec.edu.ups.toDoList.repositoy

import ec.edu.ups.toDoList.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository: JpaRepository <TaskEntity, Short> {
    fun findTaskEntitiesByIdUser(idUser:Short): List<TaskEntity>
}
