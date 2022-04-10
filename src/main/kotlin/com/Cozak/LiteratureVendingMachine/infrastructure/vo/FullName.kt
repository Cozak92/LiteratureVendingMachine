package com.Cozak.LiteratureVendingMachine.infrastructure.vo

import javax.persistence.Embeddable


@Embeddable
data class FullName(var firstName:String, var lastName:String)