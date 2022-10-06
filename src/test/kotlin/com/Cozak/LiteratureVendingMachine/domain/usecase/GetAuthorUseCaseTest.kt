package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.domain.port.outPort.AuthorPersistencePort
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.Author.IAuthorRepository
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.Literature.ILiteratureRepository
import com.ninjasquad.springmockk.MockkBean
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldStartWith
import io.mockk.every
import io.mockk.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import java.util.*

@ContextConfiguration(classes = [(GetAuthorUseCaseImpl::class)])
class GetAuthorUseCaseTest: BehaviorSpec()  {

    override fun extensions() = listOf(SpringExtension)

    @Autowired
    lateinit var authorUseCase:IAuthorUseCase

    @MockkBean
    lateinit var authorPersistencePort: AuthorPersistencePort

    init {
        given("작가를 찾는 서비스가 호출됐을 때"){
            `when`("작가를 찾아서"){
                then("Author 객체가 리턴 된다."){
                }
            }
        }
    }
}