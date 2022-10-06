package com.Cozak.LiteratureVendingMachine.application.controller

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand
import com.Cozak.LiteratureVendingMachine.domain.usecase.ILiteratureUseCase
import com.Cozak.LiteratureVendingMachine.domain.entity.Literature
import com.Cozak.LiteratureVendingMachine.domain.port.InPort.LiteratureInPort
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/literature")
class LiteratureControllerImpl(val literatureUseCase: ILiteratureUseCase): LiteratureInPort {

    @GetMapping
    override fun getLiterature(@RequestParam("text_length") textLength: Int
    ): Literature {
        val command = GetLiteratureCommand(textLength)
        return literatureUseCase.getLiteratures(command)
    }
}