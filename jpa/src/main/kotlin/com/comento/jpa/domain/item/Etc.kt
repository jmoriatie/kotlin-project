package com.comento.jpa.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity(name = "etc")
@DiscriminatorValue("0")
class Etc(name: String) : Item(name) {}
