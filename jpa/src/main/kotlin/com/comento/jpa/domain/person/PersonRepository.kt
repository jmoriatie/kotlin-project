package com.comento.jpa.domain.person

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository: CrudRepository<Person, Long> {
    fun findByPersonId(personId: Long): Person
}
