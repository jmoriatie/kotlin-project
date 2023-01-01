package com.comento.dbless.service

import com.comento.dbless.dao.PersonDao
import com.comento.dbless.domain.Person
import com.comento.dbless.dto.FilterDto
import com.comento.dbless.dto.PersonDto
import com.comento.dbless.dto.SortDto

class PersonService {

    private val dao = PersonDao()

    fun findAll() : List<PersonDto> = dao.findAll().map { p -> PersonDto.from(p) }

    fun save(dto : PersonDto) : PersonDto{
        return PersonDto.from( dao.save(Person.of(dto)) )
    }

    /**
     * 솔트 메서드
     */
    fun sort(sortDto: SortDto): MutableList<PersonDto>{
        return sortList(sortDto);
    }

    private fun sortList(sortDto : SortDto): MutableList<PersonDto>{
        val list = sortDto.persons
        val sortBy = sortDto.sortBy
        val sortOrder = sortDto.sortOrder
        //sortedBy 로 변경
        when{
            sortBy == "id" && sortOrder == "asc" -> list.sortBy { it.id }
            sortBy == "name" && sortOrder == "asc" -> list.sortBy { it.name }
            sortBy == "age" && sortOrder == "asc" -> list.sortBy { it.age }
            sortBy == "height" && sortOrder == "asc" -> list.sortBy { it.height }

            sortBy == "id" && sortOrder == "des" -> list.sortByDescending{ it.id }
            sortBy == "name" && sortOrder == "des" -> list.sortByDescending{ it.name }
            sortBy == "age" && sortOrder == "des" -> list.sortByDescending{ it.age }
            sortBy == "height" && sortOrder == "des" -> list.sortByDescending{ it.height}
        }

        return list
    }

    /**
     * 필터 메서드
     */
    fun filter(filterDto: FilterDto):  List<PersonDto>{

        //list 체이닝 형태로 진행 + 예외처리
        val (list, ageCutoff, heightCutoff, except) = filterDto

        var afterFilteringList = list.filter { it.age > (ageCutoff ?: 0) }
            .filter { it.height > (heightCutoff ?: 0) }
        if(except != null) afterFilteringList = afterFilteringList.filter { !except.contains(it.id) }

        return afterFilteringList
    }
}



