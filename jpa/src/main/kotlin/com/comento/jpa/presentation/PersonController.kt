package com.comento.jpa.presentation

import com.comento.jpa.domain.person.Person
import com.comento.jpa.domain.person.dto.PersonDto
import com.comento.jpa.domain.person.dto.PersonResponse
import com.comento.jpa.domain.person.dto.PersonSaveDto
import com.comento.jpa.domain.person.dto.PersonUpdateDto
import com.comento.jpa.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/persons")
class PersonController(
    private val service: PersonService
) {
    @GetMapping
    fun findAll() = service.findAll()

    @PostMapping("/{personId}")
    fun findById(@PathVariable personId: Int) = service.findByPersonId(personId)

    @PostMapping
    fun save(@RequestBody personDtoList: List<PersonDto>): PersonResponse = service.save(personDtoList)

    @PutMapping
    fun update(@RequestBody personDtoList: List<PersonDto>): PersonResponse = service.update(personDtoList)

//    @DeleteMapping
//    fun delete()



}
