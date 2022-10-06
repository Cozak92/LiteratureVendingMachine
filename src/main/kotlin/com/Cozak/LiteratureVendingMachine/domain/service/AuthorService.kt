package com.Cozak.LiteratureVendingMachine.domain.service

import com.Cozak.LiteratureVendingMachine.domain.port.outPort.AuthorPersistencePort
import org.springframework.stereotype.Service


@Service
class AuthorService(val authorPersistencePort: AuthorPersistencePort) {

    fun authorExists(authorId: Int): Boolean =
        authorPersistencePort
            .getAuthorById(authorId)
            ?.let {
                true
            } ?: false
}