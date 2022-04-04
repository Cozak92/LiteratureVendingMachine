package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand
import com.Cozak.LiteratureVendingMachine.infrastructure.repository.ILiteratureRepository

class LiteratureGetUseCaseImpl(val literatureRepository: ILiteratureRepository):ILiteratureUseCase {

    override fun getLiterature(command: GetLiteratureCommand){
    }
}