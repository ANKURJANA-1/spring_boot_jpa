package com.ankur.jpa.test.repository

import com.ankur.jpa.test.entity.Guardian
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

    @Query("select s from Student s where s.guardian.email=?1")
    fun findByGuardianEmail(email: String): List<Student>

    @Query(value = "select first_name from students_db where student_id=?1", nativeQuery = true)
    fun getStudentFirstNameById(studentId: Long): String

    @Query(value = "select last_name from students_db where student_id=?1", nativeQuery = true)
    fun findStudentLastNameById(studentId: Long): String

    @Query(value = "select guardian_name from students_db where student_id=?1", nativeQuery = true)
    fun findGuardianNameById(studentId: Long): String

    @Query(value = "select guardian_email from students_db where student_id=?1", nativeQuery = true)
    fun findGuardianEmailById(studentId: Long): String

    @Query(value = "select guardian_mobile from students_db where student_id=?1", nativeQuery = true)
    fun findGuardianMobileById(studentId: Long): String

}