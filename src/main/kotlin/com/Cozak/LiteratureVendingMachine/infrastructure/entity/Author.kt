package com.Cozak.LiteratureVendingMachine.infrastructure.entity

import com.Cozak.LiteratureVendingMachine.infrastructure.vo.FullName
import javax.persistence.*

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Embedded
    val fullName: FullName,
)