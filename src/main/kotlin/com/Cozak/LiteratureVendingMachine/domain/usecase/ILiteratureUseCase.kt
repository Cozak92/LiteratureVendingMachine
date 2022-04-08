package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand
import com.Cozak.LiteratureVendingMachine.infrastructure.entity.Literature

interface ILiteratureUseCase {
    fun getLiteratures(command: GetLiteratureCommand): Literature
}