package com.comento.dbless

import mu.KLogging
import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

internal val logger = KotlinLogging.logger{}

@SpringBootApplication
class DblessApplication
//TODO : Swagger 붙이기

fun main(args: Array<String>) {
    runApplication<DblessApplication>(*args)
}
