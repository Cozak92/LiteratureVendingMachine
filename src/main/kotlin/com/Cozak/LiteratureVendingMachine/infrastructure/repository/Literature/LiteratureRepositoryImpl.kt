package com.Cozak.LiteratureVendingMachine.infrastructure.repository.Literature

import com.Cozak.LiteratureVendingMachine.domain.entity.Literature
import com.Cozak.LiteratureVendingMachine.domain.entity.QLiterature.literature
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class LiteratureRepositoryImpl : QuerydslRepositorySupport(Literature::class.java), ILiteratureRepository {
    override fun findLiterature(
        text_length: Int,
    ): List<Literature> = from(literature)
        .where(literature.text_length.goe(text_length))
        .fetch()
}