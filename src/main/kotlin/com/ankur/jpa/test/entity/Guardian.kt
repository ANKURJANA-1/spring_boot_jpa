package com.ankur.jpa.test.entity

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides(
    value = [
        AttributeOverride(
            name = "name",
            column = Column(name = "guardian_name")
        ),
        AttributeOverride(
            name = "email",
            column = Column(name = "guardian_email")
        ),
        AttributeOverride(
            name = "mobile",
            column = Column(name = "guardian_mobile")
        )
    ]
)
data class Guardian(

    val name: String,
    val email: String,
    val mobile: String
)