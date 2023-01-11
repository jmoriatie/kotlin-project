package com.comento.jpa.domain.person

import com.comento.jpa.domain.person.dto.Gender
import com.comento.jpa.domain.person.dto.PersonDto
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val personId: Long?,
    var age: Int?,
    var height: Int?,
    var weight: Int?,
    var name: String,
    var gender: Gender?,
    var isMarried: Boolean?,
    var company: String?,
    var country: String
) {

    fun update(personDto: PersonDto): Long? {
        age = personDto.age
        height = personDto.height
        weight = personDto.weight
        gender = Gender.invoke(personDto.gender ?: "UNKNOWN")
        isMarried = personDto.isMarried
        company = personDto.company
        country = personDto.country.uppercase().trim()

        return this.personId
    }

    companion object {
        fun from(personDto: PersonDto): Person =
            Person(
                personDto.personId,
                personDto.age,
                personDto.height,
                personDto.weight,
                personDto.name,
                Gender.invoke(personDto.gender ?: "UNKNOWN"),
                personDto.isMarried,
                personDto.company,
                personDto.country.uppercase().trim()
            )
    }
}
