package ec.edu.ups.toDoList.controller

import ec.edu.ups.toDoList.dto.TaskDto
import ec.edu.ups.toDoList.service.ITaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
@RequestMapping(value = ["/task"])
class TaskController {
    @Autowired
    private lateinit var taskService: ITaskService

    @PostMapping
    fun save(@RequestBody taskDto: TaskDto): ResponseEntity<Any> {
        return try {
            ResponseEntity(taskService.save(taskDto), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

    @PutMapping
    fun update(@RequestBody taskDto: TaskDto): ResponseEntity<Any> {
        return try {
            taskService.update(taskDto)
            ResponseEntity(HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping
    fun getAll(@RequestParam idUser: Short): ResponseEntity<Any> {
        return try {
            ResponseEntity(taskService.getAll(idUser), HttpStatus.OK)
        } catch (ex: Exception) {
            ResponseEntity(ex.message, HttpStatus.INTERNAL_SERVER_ERROR)
        }

    }

}
