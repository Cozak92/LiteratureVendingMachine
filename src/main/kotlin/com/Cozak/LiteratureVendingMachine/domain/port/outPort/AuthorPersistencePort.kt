package com.Cozak.LiteratureVendingMachine.domain.port.outPort

import com.Cozak.LiteratureVendingMachine.domain.entity.Author

interface AuthorPersistencePort {
    fun getAuthorById(authorId: Int): Author?
}