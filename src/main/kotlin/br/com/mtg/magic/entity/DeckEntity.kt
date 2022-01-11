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
    var size: Int,
    @Column
    var black: Boolean,
    @Column
    var white: Boolean,
    @Column
    var green: Boolean,
    @Column
    var red: Boolean,
    @Column
    var blue: Boolean
)
{
    companion object;
    constructor() : this(null,"name", 0, false, false, false, false, false)
}