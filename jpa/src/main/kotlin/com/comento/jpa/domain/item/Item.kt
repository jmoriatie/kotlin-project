package com.comento.jpa.domain.item

import javax.persistence.Column
import javax.persistence.DiscriminatorColumn
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
class Item(
    itemId: Int,
    name: String,
    price: Int,
    quantity: Int,
    kind: Int,
    description: String
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = true)
    val itemId: Int? = itemId

    @Column(name = "name", nullable = false)
    var name: String = name

    @Column(name = "price", nullable = false)
    val price: Int = price

    @Column(name = "quantity", nullable = false)
    val quantity: Int = quantity

    @Column(name = "kind", nullable = false)
    val kind: Int = kind

    @Column(name = "description", nullable = true)
    val description: String = description
}
