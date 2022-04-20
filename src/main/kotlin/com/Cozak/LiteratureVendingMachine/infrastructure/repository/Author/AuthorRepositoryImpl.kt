package com.Cozak.LiteratureVendingMachine.infrastructure.repository.Author

import com.Cozak.LiteratureVendingMachine.domain.entity.Author
import com.Cozak.LiteratureVendingMachine.infrastructure.entity.QAuthor.author
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class AuthorRepositoryImpl: QuerydslRepositorySupport(Author::class.java), IAuthorRepository {
    override fun findAuthor(authorId: Int): Author? =
        from(author).where(author.id.eq(authorId)).fetchFirst()
}