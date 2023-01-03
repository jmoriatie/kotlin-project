package com.comento.dbless.presentation

import com.comento.dbless.domain.Persons
import com.comento.dbless.dto.FilterDto
import com.comento.dbless.dto.PersonDto
import com.comento.dbless.dto.SortDto
import com.comento.dbless.logger
import com.comento.dbless.service.PersonService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/persons")
class PersonRestController {

    private val service = PersonService()

    @GetMapping("/find-all")
    fun findAll() : ResponseEntity<List<PersonDto>> {
        return ResponseEntity.ok().body(service.findAll())
    }

    @PostMapping("/save")
    fun save(@RequestBody personDto: PersonDto) : Boolean{
        service.save(personDto)
        return true
    }

    @PostMapping("/sort")
    fun sort(@RequestBody sortDto: SortDto) : ResponseEntity<Any>{
        logger.info{"PersonSortDto : $sortDto"}
        return ResponseEntity.ok().body( Persons.create(sortDto.persons).sort(sortDto.sortBy, sortDto.sortOrder) )
    }

    @PostMapping("/filter")
    fun filter(@RequestBody filterDto: FilterDto) : ResponseEntity<Any>{
        logger.info { "PersonFilterDto : $filterDto" }
        val (persons, ageCutoff, heightCutoff, except) = filterDto
        return ResponseEntity.ok().body( Persons.create(persons).filter(ageCutoff, heightCutoff, except) )
    }
}
