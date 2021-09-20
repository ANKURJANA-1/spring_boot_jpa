package com.ankur.jpa.test.repository

import com.ankur.jpa.test.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface StudentRepository : JpaRepository<Student, Long> {


    fun findByFirstName(firstName: String): List<Student>

    @Query("select s from Student s where s.studentId=?1")
    fun findByStudentId(studentId: Long): Optional<Student>

    fun findByLastName(lastName: String): List<Student>

    fun findByEmail(email: String): List<Student>

}