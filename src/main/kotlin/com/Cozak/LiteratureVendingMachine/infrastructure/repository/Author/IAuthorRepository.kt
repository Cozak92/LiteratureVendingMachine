package com.Cozak.LiteratureVendingMachine.infrastructure.repository.Author

import com.Cozak.LiteratureVendingMachine.domain.entity.Author

interface IAuthorRepository{
    fun findAuthor(authorId: Int): Author?
}
