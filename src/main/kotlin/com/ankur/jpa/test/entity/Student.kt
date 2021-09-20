package com.ankur.jpa.test.entity

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students_db")
@Data
class Student(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    val studentId: Long? = null,
    val firstName: String,
    val lastName: String,

    @Column(
        name = "email_address",
        unique = true,
        nullable = false
    )
    val email: String,

    @Embedded
    val guardian: Guardian
)
