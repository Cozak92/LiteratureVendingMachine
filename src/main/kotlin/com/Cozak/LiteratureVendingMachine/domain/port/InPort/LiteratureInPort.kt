package com.Cozak.LiteratureVendingMachine.domain.port.InPort

import com.Cozak.LiteratureVendingMachine.domain.entity.Literature
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController



interface LiteratureInPort {
    fun getLiterature(@RequestParam("text_length") textLength: Int
    ): Literature
}