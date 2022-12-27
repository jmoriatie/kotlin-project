package com.comento.dbless.service

import com.comento.dbless.dao.PersonDao
import com.comento.dbless.domain.Person
import com.comento.dbless.dto.PersonDto

class PersonService {

    private val dao = PersonDao()

    fun findAll() : List<PersonDto> = dao.findAll().map { p -> PersonDto.from(p) }

    fun save(dto : PersonDto) : PersonDto{
        val person = dao.save(Person.of(dto))
        return PersonDto.from(person)
    }
}
