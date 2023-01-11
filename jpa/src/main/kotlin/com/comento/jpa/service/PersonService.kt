package com.comento.jpa.service

import com.comento.jpa.domain.person.Person
import com.comento.jpa.domain.person.PersonRepository
import com.comento.jpa.domain.person.dto.PersonDto
import com.comento.jpa.domain.person.dto.PersonResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class PersonService(
    private val repo: PersonRepository
) {

    @Transactional
    fun save(personDtoList: List<PersonDto>): PersonResponse {
        val response = PersonResponse()
        personDtoList.forEach {
            val isThis = repo.existsById(it.personId)
            when(isThis){
                false -> response.addResultTypes(1)
                true -> response.addResultTypes(0)
            }
            response.addPersonIds( repo.save( Person.from(it) ).personId ?: 0L )

            println("it=${it}")
            println("it.personId=${it.personId} / isThis=${isThis}")
        }
        return response
    }
    fun findAll(): Iterable<Person> = repo.findAll()
    fun findByPersonId(personId: Long): Person = repo.findByPersonId(personId)
    fun update(personDtoList: List<PersonDto>) : PersonResponse = this.save(personDtoList)
}
