package com.comento.dbless.presentation

import com.comento.dbless.dto.FilterDto
import com.comento.dbless.dto.PersonDto
import com.comento.dbless.dto.SortDto
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

        return ResponseEntity.ok().body(list)
    }

    @PostMapping("/filter")
    fun filter(@RequestBody filterDto: FilterDto) : ResponseEntity<Any>{

        val list = filterDto.persons
        var _list = mutableListOf<PersonDto>()

        // TODO: 제출 시간이 부족해서 우선 작성 했는데 좀 더 뱡향을 고민해보겠습니다
        val ageCutoff = filterDto.ageCutoff
        val heightCutoff = filterDto.heightCutoff
        val except = filterDto.except

        ageCutoff?.let { _list = list.filter { it.age > ageCutoff }.toMutableList() }
        heightCutoff?.let{ _list = _list.filter { it.height > heightCutoff }.toMutableList() }
        except?.let { _list = _list.filter { !except.contains(it.id) }.toMutableList()  }

        return ResponseEntity.ok().body(_list)
    }
}
