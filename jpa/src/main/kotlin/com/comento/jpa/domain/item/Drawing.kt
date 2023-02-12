package com.comento.jpa.domain.item

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity(name = "drawing")
@DiscriminatorValue("4")
class Drawing(
    name: String,
    painter: String
):Item(name){
    @Column(name="painter", nullable = false, updatable = false)
    val painter: String = painter
}
