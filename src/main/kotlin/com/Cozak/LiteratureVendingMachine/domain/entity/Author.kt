package com.Cozak.LiteratureVendingMachine.domain.entity

import com.Cozak.LiteratureVendingMachine.domain.vo.FullName
import javax.persistence.*

@Entity
data class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Embedded
    var fullName: FullName,
){
    fun changName(newFullName: FullName){
        fullName = newFullName
    }

}