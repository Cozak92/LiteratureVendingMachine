package com.Cozak.LiteratureVendingMachine.application.controller

import com.Cozak.LiteratureVendingMachine.application.command.GetLiteratureCommand
import com.Cozak.LiteratureVendingMachine.application.dto.GetLiteratureDto
import com.Cozak.LiteratureVendingMachine.domain.usecase.ILiteratureUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/literature")
class LiteratureController(val literatureUseCase: ILiteratureUseCase) {

    @GetMapping
    fun getLiterature(getLiteratureDto: GetLiteratureDto){
        val command = GetLiteratureCommand(getLiteratureDto.mood, getLiteratureDto.textLength )
        literatureUseCase.getLiterature(command)
    }
}