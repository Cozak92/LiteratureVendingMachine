package com.Cozak.LiteratureVendingMachine.domain.port.InPort

import com.Cozak.LiteratureVendingMachine.domain.entity.Author
import org.springframework.web.bind.annotation.RequestParam

interface AuthorInPort {
    fun getAuthor(@RequestParam("author_id") authorId: Int): Author
}