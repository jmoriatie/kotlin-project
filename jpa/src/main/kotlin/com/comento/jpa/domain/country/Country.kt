package com.comento.jpa.domain.country

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val zipCode: Long?,

    val name: String?,
    val capitalCity: String?
)
