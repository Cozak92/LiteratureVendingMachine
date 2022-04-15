package com.Cozak.LiteratureVendingMachine.infrastructure.vo

data class FullName(private val firstName:String, private val lastName:String) {
    val fullName = "$firstName $lastName"
}