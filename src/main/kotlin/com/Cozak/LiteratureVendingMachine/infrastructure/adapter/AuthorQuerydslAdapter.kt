package com.Cozak.LiteratureVendingMachine.infrastructure.adapter

import com.Cozak.LiteratureVendingMachine.domain.entity.Author
import com.Cozak.LiteratureVendingMachine.domain.port.outPort.AuthorPersistencePort
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.Author.IAuthorRepository
import org.springframework.stereotype.Component


@Component
class AuthorQuerydslAdapter(private val authorRepository: IAuthorRepository): AuthorPersistencePort {
    override fun getAuthorById(authorId: Int): Author? {
        return authorRepository.findAuthor(authorId)
    }
}