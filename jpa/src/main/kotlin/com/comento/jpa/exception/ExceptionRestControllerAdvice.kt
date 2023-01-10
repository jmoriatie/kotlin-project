package com.comento.jpa.exception

import com.comento.jpa.exception.dto.ErrorCode
import com.comento.jpa.exception.dto.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

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

    @ExceptionHandler(Exception::class)
    fun emptyResultDataAccessException(ex: Exception, request: HttpServletRequest): ResponseEntity<ErrorResponse>{
        val URL = request.requestURL.toString()
        return ResponseEntity.ok().body(
            ErrorResponse(ErrorCode.EMPTY_RESULT, URL)
        )
    }
}
