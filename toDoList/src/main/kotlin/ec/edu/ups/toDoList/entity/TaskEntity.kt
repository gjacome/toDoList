package ec.edu.ups.toDoList.entity

import jakarta.persistence.*


@Entity
@Table(name = "task", schema = "todolist", catalog = "todolist")
class TaskEntity (
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    var id: Short = 0,

    @Basic
    @Column(name = "id_user")
    var idUser: Short = 0,

    @Basic
    @Column(name = "description")
    var description: String = "",

    @Basic
    @Column(name = "status")
    var status: String = "PEN"
)
