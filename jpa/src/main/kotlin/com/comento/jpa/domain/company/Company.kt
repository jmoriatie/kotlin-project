package com.comento.jpa.domain.company

import com.comento.jpa.domain.person.Person
import java.sql.Date
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Company(
    _id: Long,
    foundingDate: Date,
    name: String,
    country: String,
    person: Person
) {
    // 변수 body로 옮김, default 생성자에는 필요한 파라미터만
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = true)
    private var _id: Long? = _id

    @Column(nullable = false)
    val foundingDate: Date = foundingDate

    @Column(nullable = false)
    var name: String = name

    @Column(nullable = false)
    val country: String = country

    @ManyToOne
    @JoinColumn(name="person_id")
    val person: Person = person

    val id: Long
        get() = _id ?: throw IllegalStateException()
}
