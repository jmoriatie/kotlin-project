package com.comento.dbless.dao

import com.comento.dbless.domain.Person

class PersonDao {

    private val storage : MutableMap<Long, Person> = mutableMapOf()
    private var sequence : Long = 0L

    init{
        for(i in 1..10){
            this.save( Person.from("test${i}", "tester${i}", 10 + (i * 10), 160 + (i * 2)) )
        }
    }

    fun save(person : Person) : Person {
        storage[++sequence] = person
        return person
    }

    fun findAll() : List<Person> = storage.values.toList()
}
