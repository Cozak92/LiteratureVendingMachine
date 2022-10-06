package com.Cozak.LiteratureVendingMachine.domain.entity

import javax.persistence.*


@Entity
data class Literature(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false, length = 2000)
    var text: String,
    @Column(nullable = false,)
    var text_length: Int,
    @ManyToOne
    @JoinColumn(name = "Author_ID") // 외래키
    var author: Author
    ){
    fun changeAuthor(newAuthor: Author){
        author = newAuthor
    }
}
