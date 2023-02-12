package com.comento.jpa.domain.person

import com.comento.jpa.domain.person.dto.Gender
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: CrudRepository<Person, Long> {
    fun findBy_id(personId: Long): Person
    fun findByGenderAndCountryAndAgeIsNotNull(gender: Gender, country: String): List<Person>
    fun findByGenderAndAgeIsNotNull(gender: Gender): List<Person>
}
