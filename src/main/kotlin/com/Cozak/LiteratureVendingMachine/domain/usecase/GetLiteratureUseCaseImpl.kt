package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand
import com.Cozak.LiteratureVendingMachine.infrastructure.entity.Literature
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.CustomizedLiteratureRepository
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.ILiteratureRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class GetLiteratureUseCaseImpl(val customizedLiteratureRepository: CustomizedLiteratureRepository) :
    ILiteratureUseCase {

    @Transactional
    override fun getLiteratures(command: GetLiteratureCommand): Literature =
        customizedLiteratureRepository.findLiterature(command.mood, command.textLength).random()

}