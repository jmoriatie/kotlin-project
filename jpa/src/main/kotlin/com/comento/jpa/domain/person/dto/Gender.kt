package com.comento.jpa.domain.person.dto

enum class Gender {
    UNKNOWN, MALE, FEMALE;

    companion object {
        operator fun invoke(gender: Gender): Gender {
            return values().find { it.name == gender.name.uppercase() } ?: throw RuntimeException("없는 성별 입니다.")
        }
    }
}
