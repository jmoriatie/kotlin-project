package com.comento.jpa.domain.person

import com.comento.jpa.domain.person.dto.Gender
import com.comento.jpa.domain.person.dto.PersonDto
import com.comento.jpa.domain.person.dto.PersonSaveDto
import com.comento.jpa.domain.person.dto.PersonUpdateDto
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Person(
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val personId: Int?,
    var age: Int?,
    var height: Int?,
    var weight: Int?,
    val name: String,
    var gender: Gender?,
    var isMarried: Boolean?,
    var company: String?,
    var country: String
) {

    fun update(personUpdateDto: PersonUpdateDto): Person {
        age = personUpdateDto.age
        height = personUpdateDto.height
        weight = personUpdateDto.weight
        gender = personUpdateDto.gender
        isMarried = personUpdateDto.isMarried
        company = personUpdateDto.company
        country = personUpdateDto.country
        return this
    }

    companion object {
        fun from(personSaveDto: PersonSaveDto): Person =
            Person(
                personSaveDto.personId,
                personSaveDto.age,
                personSaveDto.height,
                personSaveDto.weight,
                personSaveDto.name,
                personSaveDto.gender,
                personSaveDto.isMarried,
                personSaveDto.company,
                personSaveDto.country
            )

        fun from(personDto: PersonDto): Person =
            Person(
                personDto.personId,
                personDto.age,
                personDto.height,
                personDto.weight,
                personDto.name,
                Gender.invoke(personDto.gender),
                personDto.isMarried,
                personDto.company,
                personDto.country
            )
    }
}
