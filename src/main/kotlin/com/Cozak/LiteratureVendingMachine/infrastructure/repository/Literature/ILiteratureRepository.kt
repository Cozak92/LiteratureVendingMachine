package com.Cozak.LiteratureVendingMachine.infrastructure.repository.Literature

import com.Cozak.LiteratureVendingMachine.domain.entity.Literature


interface ILiteratureRepository {
    fun findLiterature(text_length: Int): List<Literature>
}