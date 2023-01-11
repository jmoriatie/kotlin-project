package com.comento.jpa.domain.person.dto

enum class Gender(
    val code: Int,
) {
    UNKNOWN(0), MALE(1), FEMALE(2);

    companion object {
        operator fun invoke(gender: String): Gender {
            if (gender == "null") return UNKNOWN

            return values().find { it.name == gender.uppercase() } ?: throw RuntimeException("없는 성별 입니다.")
        }
    }
}
