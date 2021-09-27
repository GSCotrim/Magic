package br.com.mtg.magic

import javax.persistence.*

@Entity
@Table(name = "decks")
data class DeckEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column
    var name: String,
    @Column
    var size: Int
)
{
    companion object;
    constructor() : this(null,"name", 0)
}