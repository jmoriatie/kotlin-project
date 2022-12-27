package com.comento.dbless.util

import com.comento.dbless.dao.PersonDao
import com.comento.dbless.domain.Person
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class Data {

    @PostConstruct
    fun testIdInit() : Unit{
        val personDao = PersonDao()
        for(i in 1..10){
            val person = Person.from("test${i}", "tester${i}", 10 + (i + 5), 160 + (i * 2))
            personDao.save( person )
        }
    }
}
