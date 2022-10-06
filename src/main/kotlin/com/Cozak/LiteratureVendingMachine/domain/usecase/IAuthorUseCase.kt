package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.domain.entity.Author

interface IAuthorUseCase {
    fun getAuthor(authorId:Int): Author
}