package com.comento.dbless.domain

import com.comento.dbless.dto.PersonDto

class Person private constructor(val id : String) {
    var name : String = ""
    var age : Int = -1
    var height : Int = -1

    companion object{
        fun from(id : String,
                 name : String,
                 age : Int,
                 height : Int): Person{
            val newPerson = Person(id)
            newPerson.name = name
            newPerson.age = age
            newPerson.height = height
            return newPerson
        }

        fun of(personDto : PersonDto) : Person{
            val newPerson = Person(personDto.id)
            newPerson.name = personDto.name
            newPerson.age = personDto.age
            newPerson.height = personDto.height
            return newPerson
        }
    }
}
