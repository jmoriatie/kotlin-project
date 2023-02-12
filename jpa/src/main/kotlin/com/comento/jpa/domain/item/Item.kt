package com.comento.jpa.domain.item

import org.hibernate.boot.model.naming.IllegalIdentifierException
import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.Table

@Entity
@Table(name = "item")
// 상속을 이용한 '단일 테이블' 전략
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// kind를 구분 colmun 으로 설정
@DiscriminatorColumn(name = "kind")
abstract class Item(
    name: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = true)
    private var _id: Int? = null

    @Column(name = "name", nullable = false)
    var name: String = name

    @Column(name = "price", nullable = false)
    val price: Int = 0

    @Column(name = "quantity", nullable = false)
    val quantity: Int = 0

//    @Column(name = "kind", nullable = false)
//    val kind: Int = kind

    @Column(name = "description", nullable = true)
    val description: String = ""

    val id: Int
        get() = _id ?: throw IllegalStateException()
}
