package com.Cozak.LiteratureVendingMachine.domain.usecase

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand

interface ILiteratureUseCase {
    fun getLiterature(command: GetLiteratureCommand)
}