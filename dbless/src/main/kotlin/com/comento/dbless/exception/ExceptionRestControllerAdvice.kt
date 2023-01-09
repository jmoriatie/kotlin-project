package com.comento.dbless.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.lang.String

@RestControllerAdvice
class ExceptionRestControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun invalidRequestBodyException(ex: MethodArgumentNotValidException): List<kotlin.String> {
        return ex.bindingResult
            .fieldErrors
            .distinct()
            .map { e -> String.format("%s : %s", e.field, e.defaultMessage) }
            .toList()
    }
}
