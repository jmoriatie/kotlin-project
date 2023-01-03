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



