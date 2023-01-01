package com.comento.dbless.domain

import com.comento.dbless.dto.PersonDto

class Person private constructor(val id : String) {
    val name : String
        get() = this._name
    val age : Int
        get() = this.age
    val height : Int
        get() = this._height

    var _name : String = ""
    var _age : Int = -1
    var _height : Int = -1

    companion object{
        fun from(id : String,
                 name : String,
                 age : Int,
                 height : Int): Person{
            val newPerson = Person(id)
            newPerson._name = name
            newPerson._age = age
            newPerson._height = height
            return newPerson
        }

        fun of(personDto : PersonDto) : Person{
            val newPerson = Person(personDto.id)
            newPerson._name = personDto.name
            newPerson._age = personDto.age
            newPerson._height = personDto.height
            return newPerson
        }
    }
}
