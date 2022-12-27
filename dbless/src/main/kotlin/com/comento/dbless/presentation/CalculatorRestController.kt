package com.comento.dbless.presentation

import com.comento.dbless.service.CalculatorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("/api/v1/calculator")
class CalculatorRestController {

    private val service = CalculatorService()

    @GetMapping("/generate/{range}")
    fun generate(@PathVariable range : String) : ResponseEntity<Any>{
        val numbers = range.split("~")

        println(numbers[0].toDouble())
        println(numbers[1].toDouble())
        val randomNum = service.getRandomNum(numbers[0], numbers[1])

        return ResponseEntity.ok().body(randomNum)
    }
}
