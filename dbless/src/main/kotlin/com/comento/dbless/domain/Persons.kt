package com.comento.dbless.domain

import com.comento.dbless.dto.PersonDto
import com.comento.dbless.dto.SortDto

class Persons private constructor(sortDto: SortDto){
    private val persons: MutableList<PersonDto> = sortDto.persons
    private val sortBy = sortDto.sortBy
    private val sortOrder = sortDto.sortOrder

    fun sort(): MutableList<PersonDto>{
        when{
            sortBy == "id" && sortOrder == "asc" -> persons.sortBy { it.id }
            sortBy == "name" && sortOrder == "asc" -> persons.sortBy { it.name }
            sortBy == "age" && sortOrder == "asc" -> persons.sortBy { it.age }
            sortBy == "height" && sortOrder == "asc" -> persons.sortBy { it.height }

            sortBy == "id" && sortOrder == "des" -> persons.sortByDescending{ it.id }
            sortBy == "name" && sortOrder == "des" -> persons.sortByDescending{ it.name }
            sortBy == "age" && sortOrder == "des" -> persons.sortByDescending{ it.age }
            sortBy == "height" && sortOrder == "des" -> persons.sortByDescending{ it.height}
        }
        return persons
    }

    companion object{
        fun create(sortDto: SortDto): Persons = Persons(sortDto)
    }
}
