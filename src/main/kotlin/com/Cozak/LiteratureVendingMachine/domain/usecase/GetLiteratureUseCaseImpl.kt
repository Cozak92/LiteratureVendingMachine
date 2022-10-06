package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand
import com.Cozak.LiteratureVendingMachine.domain.entity.Literature
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.Literature.ILiteratureRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class GetLiteratureUseCaseImpl(val iLiteratureRepository: ILiteratureRepository) :
    ILiteratureUseCase {

    @Transactional
    override fun getLiteratures(command: GetLiteratureCommand): Literature =
        iLiteratureRepository.findLiterature(command.textLength).random()

}