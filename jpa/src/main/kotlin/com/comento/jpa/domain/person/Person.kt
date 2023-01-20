package com.comento.jpa.domain.person

import com.comento.jpa.domain.company.Company
import com.comento.jpa.domain.person.dto.Gender
import com.comento.jpa.domain.person.dto.PersonDto
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Person(
    _id: Long?,
    age: Int?,
    height: Int?,
    weight: Int?,
    name: String,
    isMarried: Boolean?,
    company: MutableList<Company>?,
    country: String,
    gender: Gender? = Gender.UNKNOWN
) {
    // 주요 setter protected 로 변경
    // 주요 setter 별도의 fun 정의 해서 사용(캡슐화)
    // default 값이 있는 파라미터는 기본 파라미터에서 뒤로 보낸다 ex) country = null
    // TODO : JPA 관계 매핑때 lazy 로딩 -> 해당 객체를 불렀을 때만 프록시로 가져옴 , entity -> final 일 경우 프록시 사용 X
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id", nullable = true)
    private var _id: Long? = _id

    @Column(name = "age", nullable = false)
    var age: Int? = age

    @Column(name = "height", nullable = true)
    var height: Int? = height

    @Column(name = "weight", nullable = true)
    var weight: Int? = weight

    @Column(name = "name", nullable = false)
    var name: String = name

    @Column(name = "is_married", nullable = true)
    var isMarried: Boolean? = isMarried

    @OneToMany(fetch = FetchType.LAZY)
    @Column(name = "company", nullable = true, updatable = true)
    var company: MutableList<Company>? = company

    @Column(name = "country", nullable = false)
    var country: String = country
        protected set

    @Column(name = "gender", nullable = true)
    var gender: Gender? = gender

    val id: Long
        get() = _id ?: throw IllegalStateException()

    fun setCountry(country: String){
        this.country = country
    }

    override fun toString(): String {
        return "Person(personId=${this.id}, age=${this.age}, height=${this.height}, weight=${this.weight}, name=${this.name}, " +
            "gender=${this.gender}, isMarried=${this.isMarried}, company=${this.company}, country=${this.country})"
    }

    companion object {
        fun from(personDto: PersonDto): Person =
            Person(
                personDto.personId,
                personDto.age,
                personDto.height,
                personDto.weight,
                personDto.name,
                personDto.isMarried,
                personDto.company,
                personDto.country.uppercase().trim(),
                Gender(personDto.gender ?: Gender.UNKNOWN ) // enum operator invoke 메서드 생략가능
            )
    }
}
