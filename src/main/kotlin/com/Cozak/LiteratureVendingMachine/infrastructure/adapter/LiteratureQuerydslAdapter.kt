package com.Cozak.LiteratureVendingMachine.infrastructure.adapter

import com.Cozak.LiteratureVendingMachine.domain.entity.Literature
import com.Cozak.LiteratureVendingMachine.domain.port.outPort.LiteraturePersistencePort
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.Literature.ILiteratureRepository

class LiteratureQuerydslAdapter(private val literatureRepository: ILiteratureRepository): LiteraturePersistencePort {
    override fun findLiteratureByTextLength(text_length: Int): List<Literature> {
        return literatureRepository.findLiterature(text_length)
    }
}