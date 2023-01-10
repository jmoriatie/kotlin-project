package com.comento.jpa.exception.dto

data class ErrorResponse(
    val result: ErrorCode,
    val faultRequest: String?
){
    val code = result.code
    val message = result.message
}
