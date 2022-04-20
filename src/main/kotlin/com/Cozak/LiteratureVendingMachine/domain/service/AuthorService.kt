package com.Cozak.LiteratureVendingMachine.domain.service

import com.Cozak.LiteratureVendingMachine.infrastructure.repository.Author.IAuthorRepository
import org.springframework.stereotype.Service


@Service
class AuthorService(val authorRepository: IAuthorRepository) {

    fun authorExists(authorId: Int): Boolean =
        authorRepository
            .findAuthor(authorId)
            ?.let {
                true
            } ?: false
}