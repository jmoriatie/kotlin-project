package com.comento.jpa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaApplication

/**
 *TODO:
 * validation
 * test case
 * swagger
 */

fun main(args: Array<String>) {
    runApplication<JpaApplication>(*args)
}
