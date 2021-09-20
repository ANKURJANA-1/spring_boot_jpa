package com.ankur.jpa.test.controller

import com.ankur.jpa.test.entity.Guardian
import com.ankur.jpa.test.entity.Student
import com.ankur.jpa.test.services.StudentService
import org.springframework.beans.factory.annotation.Autowired
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

    @GetMapping("/guardianEmail/{email}")
    fun getStudentByGuardianEmail(@PathVariable email: String) = studentService.getStudentByGuardianEmail(email)

    @GetMapping("/firstName/id/{id}")
    fun getStudentFirstNameById(@PathVariable id: String) = studentService.getStudentFirstNameByStudentId(id.toLong())

    @GetMapping("/lastName/id/{id}")
    fun getStudentLastNameById(@PathVariable id: String) = studentService.getStudentLastNameByStudentId(id.toLong())

    @GetMapping("/fullName/id/{id}")
    fun getStudentFullNameById(@PathVariable id: String) = studentService.getStudentFullNameById(id.toLong())

    @GetMapping("/guardianName/id/{id}")
    fun getStudentGuardianName(@PathVariable id: String) = studentService.getStudentGuardianName(id.toLong())

    @GetMapping("/guardianEmail/id/{id}")
    fun getStudentGuardianEmail(@PathVariable id: String) = studentService.getStudentGuardianEmail(id.toLong())

    @GetMapping("/guardianMobile/id/{id}")
    fun getStudentGuardianMobile(@PathVariable id: String) = studentService.getStudentGuardianMobile(id.toLong())
}