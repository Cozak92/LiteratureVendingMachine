package com.Cozak.LiteratureVendingMachine.application.controller

import com.Cozak.LiteratureVendingMachine.domain.entity.Author
import com.Cozak.LiteratureVendingMachine.domain.port.InPort.AuthorInPort
import com.Cozak.LiteratureVendingMachine.domain.service.AuthorService
import com.Cozak.LiteratureVendingMachine.domain.usecase.IAuthorUseCase
import com.Cozak.LiteratureVendingMachine.domain.vo.FullName
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldEndWith
import io.kotest.matchers.types.shouldBeInstanceOf
import io.mockk.every
import io.mockk.verify
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [(AuthorControllerImpl::class)])
class AuthorControllerTest: BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    lateinit var authorInPort: AuthorInPort

    @MockkBean
    lateinit var authorUseCase: IAuthorUseCase

    @MockkBean
    lateinit var authorService: AuthorService

    init {
        given("작가 조회가 들어왔을 때"){
            val authorId = 3

            `when`("작가를 찾았다면") {
                every { authorService.authorExists(authorId) } returns true
                every { authorUseCase.getAuthor(authorId) } returns Author(id=3, fullName = FullName("SeungHyuk","Shin"))

                then("Author를 리턴한다."){
                    val response = authorInPort.getAuthor(authorId)
                    verify(exactly = 1) { authorService.authorExists(authorId) }
                    verify(exactly = 1) { authorUseCase.getAuthor(authorId) }
                    response.shouldNotBe(null)
                    response.shouldBeInstanceOf<Author>()
                    response.id.shouldBeExactly(3)
                }
            }
            `when`("작가를 못찾았다면"){
                every { authorService.authorExists(authorId) } returns false
                every { authorUseCase.getAuthor(authorId) } returns Author(id=3, fullName = FullName("SeungHyuk","Shin"))

                then("NoSuchElementException을 던진다."){
                    val response = shouldThrowExactly<NoSuchElementException > {
                        authorInPort.getAuthor(authorId)
                    }
                    verify(exactly = 1) { authorService.authorExists(authorId) }
                    verify(exactly = 0) { authorUseCase.getAuthor(authorId) }

                    response.message.shouldNotBe(null)
                    response.message.shouldEndWith(authorId.toString())


                }
            }
        }
    }
}
