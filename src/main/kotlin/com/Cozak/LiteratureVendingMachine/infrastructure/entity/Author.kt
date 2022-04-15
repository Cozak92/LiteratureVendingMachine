package com.Cozak.LiteratureVendingMachine.infrastructure.entity

import com.Cozak.LiteratureVendingMachine.infrastructure.vo.FullName
import javax.persistence.*

@Entity
class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false, length = 25)
    @Embedded
    @AttributeOverride(name = "fullName", column = Column(name = "name"))
    val name: FullName,

    ) {
}