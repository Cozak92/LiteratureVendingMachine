package com.Cozak.LiteratureVendingMachine.domain.service

import com.Cozak.LiteratureVendingMachine.domain.port.outPort.AuthorPersistencePort
import com.Cozak.LiteratureVendingMachine.domain.usecase.GetAuthorUseCaseImpl
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [(AuthorService::class)])
class AuthorServiceTest: BehaviorSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    lateinit var authorService: AuthorService

    @MockkBean
    lateinit var authorPersistencePort: AuthorPersistencePort
}