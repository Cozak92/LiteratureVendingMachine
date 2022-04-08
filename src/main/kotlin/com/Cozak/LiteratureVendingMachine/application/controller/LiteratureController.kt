package com.Cozak.LiteratureVendingMachine.application.controller

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand
import com.Cozak.LiteratureVendingMachine.domain.usecase.ILiteratureUseCase
import com.Cozak.LiteratureVendingMachine.infrastructure.entity.Literature
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/literature")
class LiteratureController(val literatureUseCase: ILiteratureUseCase) {

    @GetMapping
    fun getLiterature(@RequestParam("mood") mood: String,
                      @RequestParam("text_length") textLength: Int
    ): Literature {
        val command = GetLiteratureCommand(mood, textLength)
        return literatureUseCase.getLiteratures(command)
    }
}