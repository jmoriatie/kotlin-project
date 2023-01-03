package com.comento.dbless.domain

import com.comento.dbless.dto.FilterDto
import com.comento.dbless.dto.PersonDto
import com.comento.dbless.dto.SortDto

class Persons private constructor(private val persons: MutableList<PersonDto>){

    fun sort(sortBy: String, sortOrder: String): List<PersonDto>{
        when{
            sortBy == "id" && sortOrder == "asc" -> this.persons.sortBy { it.id }
            sortBy == "name" && sortOrder == "asc" -> this.persons.sortBy { it.name }
            sortBy == "age" && sortOrder == "asc" -> this.persons.sortBy { it.age }
            sortBy == "height" && sortOrder == "asc" -> this.persons.sortBy { it.height }

            sortBy == "id" && sortOrder == "des" -> this.persons.sortByDescending{ it.id }
            sortBy == "name" && sortOrder == "des" -> this.persons.sortByDescending{ it.name }
            sortBy == "age" && sortOrder == "des" -> this.persons.sortByDescending{ it.age }
            sortBy == "height" && sortOrder == "des" -> this.persons.sortByDescending{ it.height}
        }
        return persons
    }

    fun filter(ageCutoff: Int?, heightCutoff: Int?, except: MutableList<String>?):  List<PersonDto>{
        //list 체이닝 형태로 진행 + 예외처리
        var afterFilteringList = persons.filter { it.age > (ageCutoff ?: 0) }
                                        .filter { it.height > (heightCutoff ?: 0) }

        if(except != null) afterFilteringList = afterFilteringList.filter { !except.contains(it.id) }

        return afterFilteringList
    }

    companion object{
        fun create(persons: MutableList<PersonDto>): Persons = Persons(persons)
    }
}
