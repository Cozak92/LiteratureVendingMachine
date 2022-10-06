package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.domain.port.outPort.LiteraturePersistencePort
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration


@ContextConfiguration(classes = [(GetLiteratureUseCaseImpl::class)])
class GetLiteratureUseCaseTest: BehaviorSpec() {

    @Autowired
    lateinit var literatureUseCase: IAuthorUseCase

    @MockkBean
    lateinit var literaturePersistencePort: LiteraturePersistencePort

    init {
        given("문학을 찾는 서비스가 호출 됐을 때"){
            `when`("문자열 길이로 문학을 찾으면"){
                then("가져온 문학 리스트중 하나를 랜덤으로 반환한다."){

                }
            }
            `when`("문자열 길이에 맞는 문학이 없으면"){
                then("NoSuchElementException를 던진다."){

                }
            }
        }
    }


}