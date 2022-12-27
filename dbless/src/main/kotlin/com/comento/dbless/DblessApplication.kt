package com.comento.dbless

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DblessApplication

//TODO : Logger 만들기
//TODO : Swagger 붙이기

fun main(args: Array<String>) {
    runApplication<DblessApplication>(*args)
}
