package com.comento.jpa.service

import com.comento.jpa.domain.person.Person
import com.comento.jpa.domain.person.PersonRepository
import com.comento.jpa.domain.person.dto.PersonDto
import com.comento.jpa.domain.person.dto.PersonSaveDto
import com.comento.jpa.domain.person.dto.PersonUpdateDto
import com.comento.jpa.domain.person.dto.PersonResponse
import com.comento.jpa.exception.custom_exceptions.CustomEmptyResultDataAccessException
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
            when(repo.existsById(it.personId)){
                false -> { // 없는 id -> 저장
                    response.addResultTypes(1)
                    response.addPersonIds( repo.save(Person.from(it)).personId ?: 0 )
                }
                true ->{ // 있는 id -> update
                    response.addResultTypes(0)
                    response.addPersonIds( repo.save(Person.from(it)).personId ?: 0 )
                }
            }
        }
        return response
    }
    fun findAll(): Iterable<Person> = repo.findAll()
    fun findByPersonId(personId: Int): Person = repo.findByPersonId(personId)
    fun update(personDtoList: List<PersonDto>) : PersonResponse = this.save(personDtoList)
}
