package com.Cozak.LiteratureVendingMachine.infrastructure.entity

import javax.persistence.*


@Entity
data class Literature(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false, length = 300)
    val text: String,
    @Column(nullable = false, length = 50)
    val mood: String,
    @Column(nullable = false,)
    val text_length: Int,
    @ManyToOne
    @JoinColumn(name = "Author_ID") // 외래키
    val author: Author
    )