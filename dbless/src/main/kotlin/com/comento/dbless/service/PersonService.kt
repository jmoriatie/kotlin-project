package com.comento.dbless.service

import com.comento.dbless.dao.PersonDao
import com.comento.dbless.domain.Person
import com.comento.dbless.dto.FilterDto
import com.comento.dbless.dto.PersonDto
import com.comento.dbless.dto.SortDto
import org.springframework.http.ResponseEntity

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
        val list = sortDto.persons
        val sortBy = sortDto.sortBy
        val sortOrder = sortDto.sortOrder

        // TODO: 제출 시간이 부족해서 우선 작성 했는데 좀 더 뱡향을 고민해보겠습니다
        when{
            sortBy == "id" && sortOrder == "asc" -> list.sortWith( compareBy<PersonDto> { it.id })
            sortBy == "name" && sortOrder == "asc" -> list.sortWith( compareBy<PersonDto> { it.name })
            sortBy == "age" && sortOrder == "asc" -> list.sortWith( compareBy<PersonDto> { it.age })
            sortBy == "height" && sortOrder == "asc" -> list.sortWith( compareBy<PersonDto> { it.height })

            sortBy == "id" && sortOrder == "des" -> list.sortWith( compareBy<PersonDto> { it.id }.reversed())
            sortBy == "name" && sortOrder == "des" -> list.sortWith( compareBy<PersonDto> { it.name }.reversed())
            sortBy == "age" && sortOrder == "des" -> list.sortWith( compareBy<PersonDto> { it.age }.reversed())
            sortBy == "height" && sortOrder == "des" -> list.sortWith( compareBy<PersonDto> { it.height }.reversed())
        }
        return list
    }

    /**
     * 필터 메서드
     */
    fun filter(filterDto: FilterDto):  MutableList<PersonDto>{
        val list = filterDto.persons
        var _list = mutableListOf<PersonDto>()

        // TODO: 제출 시간이 부족해서 우선 작성 했는데 좀 더 뱡향을 고민해보겠습니다
        val ageCutoff = filterDto.ageCutoff
        val heightCutoff = filterDto.heightCutoff
        val except = filterDto.except

        // null 확인 후 _list 를 계속 변경해주는 방식
        ageCutoff?.let { _list = list.filter { it.age > ageCutoff }.toMutableList() }
        heightCutoff?.let{ _list = _list.filter { it.height > heightCutoff }.toMutableList() }
        except?.let { _list = _list.filter { !except.contains(it.id) }.toMutableList()  }

        return _list
    }

}
