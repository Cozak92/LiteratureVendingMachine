package com.Cozak.LiteratureVendingMachine.domain.port.outPort

import com.Cozak.LiteratureVendingMachine.domain.entity.Literature

interface LiteraturePersistencePort {
    fun findLiteratureByTextLength(text_length: Int): List<Literature>
}