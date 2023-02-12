package com.comento.jpa.domain.item

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity(name = "book")
@DiscriminatorValue("3")
class Book(
    name: String,
    author: String
): Item(name){

    @Column(name = "author", nullable=false, updatable = false)
    val author: String = author
}
