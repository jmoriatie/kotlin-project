package com.comento.dbless.dto

import com.comento.dbless.domain.Person

class PersonDto private constructor(
    val id : String,
    val name : String,
    val age : Int,
    val height : Int) {

    companion object{
        fun of(id : String,
               name : String,
               age : Int,
               height : Int) : PersonDto{
            val person = Person.from(id, name, age, height)
            return PersonDto.from(person)
        }

        fun from(person : Person) : PersonDto = PersonDto(person.id, person.name, person.age, person.height)
    }
}
