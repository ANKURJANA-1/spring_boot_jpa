package com.ankur.jpa.test.services

import com.ankur.jpa.test.entity.Student
import com.ankur.jpa.test.repository.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class StudentService {

    @Autowired
    lateinit var studentRepository: StudentRepository

    fun getAllStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun saveStudent(student: Student) {
        studentRepository.save(student)
    }

    fun getStudentByFirstName(firstName: String): List<Student> {
        return studentRepository.findByFirstName(firstName)
    }

    fun getStudentById(studentId: Long): Optional<Student> {
        if (!studentRepository.findById(studentId).isPresent) {
            throw IllegalAccessException("Data not available")
        }
        return studentRepository.findByStudentId(studentId)
    }

    fun getStudentByLastName(lastName: String): List<Student> {
        return studentRepository.findByLastName(lastName)
    }

    fun getStudentByEmail(email: String): List<Student> {
        return studentRepository.findByEmail(email)
    }

    fun getStudentByGuardianEmail(email: String): List<Student> {
        return studentRepository.findByGuardianEmail(email)
    }

    fun getStudentFirstNameByStudentId(id: Long): String {
        return studentRepository.getStudentFirstNameById(id)
    }

    fun getStudentLastNameByStudentId(id: Long): String {
        return studentRepository.findStudentLastNameById(id)
    }

    fun getStudentFullNameById(id: Long): String {
        return studentRepository.getStudentFirstNameById(id) + " " + studentRepository.findStudentLastNameById(id)
    }

    fun getStudentGuardianName(id: Long): String {
        return studentRepository.findGuardianNameById(id)
    }

    fun getStudentGuardianEmail(id: Long): String {
        return studentRepository.findGuardianEmailById(id)
    }

    fun getStudentGuardianMobile(id: Long): String {
        return studentRepository.findGuardianMobileById(id)
    }

}