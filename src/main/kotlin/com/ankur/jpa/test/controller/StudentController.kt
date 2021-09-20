package com.ankur.jpa.test.controller

import com.ankur.jpa.test.entity.Guardian
import com.ankur.jpa.test.entity.Student
import com.ankur.jpa.test.services.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/students")
class StudentController {
    @Autowired
    lateinit var studentService: StudentService

    @GetMapping
    fun getAllStudent() = studentService.getAllStudents()

    @PostMapping
    fun saveStudent(@RequestBody student: Student) {
        studentService.saveStudent(student)
    }

    @GetMapping("/firstName/{firstName}")
    fun getStudentByFirstName(@PathVariable firstName: String) = studentService.getStudentByFirstName(firstName)

    @GetMapping("/id/{id}")
    fun getStudentById(@PathVariable id: Long) = studentService.getStudentById(id)

    @GetMapping("/lastName/{lastName}")
    fun getStudentByLastName(@PathVariable lastName: String) = studentService.getStudentByLastName(lastName)

    @GetMapping("/email/{email}")
    fun getStudentByEmail(@PathVariable email: String) = studentService.getStudentByEmail(email)
}