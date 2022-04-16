package com.Cozak.LiteratureVendingMachine.application.config

import com.Cozak.LiteratureVendingMachine.infrastructure.repository.LiteratureRepositoryImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {
    @Bean
    fun CustomizedLiteratureRepository(): LiteratureRepositoryImpl = LiteratureRepositoryImpl()
}