package com.comento.jpa.domain.person.dto

enum class Gender {
    UNKNOWN, MALE, FEMALE;

    companion object {
        operator fun invoke(gender: String): Gender {
            if (gender == "null") return UNKNOWN
            return values().find { it.name == gender.uppercase() } ?: throw RuntimeException("없는 성별 입니다.")
        }
    }
}
