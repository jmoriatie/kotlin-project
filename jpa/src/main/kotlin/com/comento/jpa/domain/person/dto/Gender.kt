package com.comento.jpa.domain.person.dto

enum class Gender {
    MALE, FEMALE, UNKNOWN;

    companion object {
        operator fun invoke(gender: String): Gender {
            return values().find { it.name == gender.uppercase() } ?: throw RuntimeException("없는 성별 입니다.")
        }
    }
}
