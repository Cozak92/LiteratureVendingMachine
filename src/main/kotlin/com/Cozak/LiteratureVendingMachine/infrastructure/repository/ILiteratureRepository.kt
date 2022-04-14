package com.Cozak.LiteratureVendingMachine.infrastructure.repository

import com.Cozak.LiteratureVendingMachine.infrastructure.entity.Literature
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ILiteratureRepository : JpaRepository<Literature, Int> {
}