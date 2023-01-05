package com.comento.jpa.exception.dto

enum class ErrorCode(code: Int, message: String) {

    EMPTY_RESULT(400, "올바르지 않은 요청입니다.")

}
