package com.Cozak.LiteratureVendingMachine.infrastructure.repository

import com.Cozak.LiteratureVendingMachine.infrastructure.entity.Literature

interface CustomizedLiteratureRepository {
    fun findLiterature(mood: String, text_length: Int): List<Literature>
}