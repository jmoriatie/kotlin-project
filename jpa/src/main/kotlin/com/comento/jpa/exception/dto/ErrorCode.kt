package com.comento.jpa.exception.dto

enum class ErrorCode(
    val code: Int,
    val message: String
    ) {
    EMPTY_RESULT(400, "요청에 대한 값이 없습니다. 요청 값을 확인해주세요.")
}
