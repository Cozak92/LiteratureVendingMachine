package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.domain.entity.Author
import com.Cozak.LiteratureVendingMachine.domain.port.outPort.AuthorPersistencePort
import org.springframework.stereotype.Service

@Service
class GetAuthorUseCaseImpl(private val authorPersistencePort: AuthorPersistencePort): IAuthorUseCase {
    override fun getAuthor(authorId: Int): Author {
        return authorPersistencePort.getAuthorById(authorId)!!
    }
}