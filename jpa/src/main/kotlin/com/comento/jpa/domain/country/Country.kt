package com.comento.jpa.domain.country

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Country(
    zipCode: Long?,
    name: String,
    capitalCity: String?
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="zip_code", nullable = true)
    val zipCode: Long? = zipCode

    @Column(name="name", nullable = false)
    val name: String = name//type 변경 non-nullable column 어노테이션

    @Column(name="capital_city", nullable = true)
    val capitalCity: String? = capitalCity
}
