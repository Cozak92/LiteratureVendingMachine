package com.Cozak.LiteratureVendingMachine.infrastructure.repository

import com.Cozak.LiteratureVendingMachine.infrastructure.entity.Literature
import com.Cozak.LiteratureVendingMachine.infrastructure.entity.QLiterature.literature
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository


class LiteratureRepositoryImpl : QuerydslRepositorySupport(Literature::class.java), CustomizedLiteratureRepository {
    override fun findLiterature(
        mood: String,
        text_length: Int,
    ): List<Literature> = from(literature)
        .where(literature.mood.eq(mood))
        .where(literature.text_length.goe(text_length))
        .fetch()
}