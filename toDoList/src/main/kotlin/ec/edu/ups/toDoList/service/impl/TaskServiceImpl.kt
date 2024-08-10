package ec.edu.ups.toDoList.service.impl

import ec.edu.ups.toDoList.dto.TaskDto
import ec.edu.ups.toDoList.mapper.TaskMapper
import ec.edu.ups.toDoList.repositoy.TaskRepository
import ec.edu.ups.toDoList.service.ITaskService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service
class TaskServiceImpl: ITaskService {
    private val log = LoggerFactory.getLogger(TaskServiceImpl::class.toString())

    @Autowired
    private lateinit var taskRepository: TaskRepository


    override fun save(taskDto: TaskDto): TaskDto {
        log.info("TaskServiceImpl::save - INIT - taskDto: [{}]", taskDto)
        return try {
            val response = taskRepository.save(TaskMapper.buildEntityFromDto(taskDto))
            TaskMapper.buildDtoFromEntity(response)
        } catch (ex: Exception) {
            log.error(
                "TaskServiceImpl::save - ERROR - error: [{}]", ex.message
            )
            throw Exception(
                "Error to save task"
            )
        }
    }

    override fun update(taskDto: TaskDto) {
        log.info("TaskServiceImpl::update - INIT - taskDto: [{}]", taskDto.toString())
        try {
            val current = taskRepository.findById(taskDto.id).orElseThrow {
                throw Exception(
                    "Error to save task"
                )
            }
            current.status = taskDto.status
             taskRepository.save(current)
        } catch (ex: Exception) {
            log.error(
                "TaskServiceImpl::save - ERROR - error: [{}]", ex.message
            )
            throw Exception(
                "Error to update task"
            )
        }
    }

    override fun getAll(idUser: Short): List<TaskDto> {
        log.info("TaskServiceImpl::getAll - INIT - idUser: [{}]", idUser)
        try {

            val response = ArrayList<TaskDto>()
            taskRepository.findTaskEntitiesByIdUser(idUser).forEach {
                response.add(TaskMapper.buildDtoFromEntity(it))
            }
            return response
        } catch (ex: Exception) {
            log.error(
                "TaskServiceImpl::getAll - ERROR - error: [{}]", ex.message
            )
            throw Exception(
                "Error to get all task by idUser"
            )
        }

    }

}
