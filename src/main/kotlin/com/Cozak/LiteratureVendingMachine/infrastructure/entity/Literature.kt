package com.Cozak.LiteratureVendingMachine.infrastructure.entity

import javax.persistence.*


@Entity
class Literature(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false, length = 300)
    @AttributeOverride(name = "value", column = Column(name = "text"))
    val text: String,
    @ManyToOne
    @JoinColumn(name = "Author_ID") // 외래키
    val author: Author
    ) {

}