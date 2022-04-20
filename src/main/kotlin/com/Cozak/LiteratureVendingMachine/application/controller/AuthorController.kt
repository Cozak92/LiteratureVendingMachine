package com.Cozak.LiteratureVendingMachine.application.controller

import com.Cozak.LiteratureVendingMachine.domain.entity.Author
import com.Cozak.LiteratureVendingMachine.domain.service.AuthorService
import com.Cozak.LiteratureVendingMachine.domain.usecase.IAuthorUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/author")
class AuthorController(val authorService: AuthorService, val authorUseCase: IAuthorUseCase) {

    @GetMapping
    fun getAuthor(@RequestParam("author_id") authorId: Int): Author{
        if(!authorService.authorExists(authorId)){
            TODO("Throw Exception")
        }
        return authorUseCase.getAuthor(authorId)
    }
}