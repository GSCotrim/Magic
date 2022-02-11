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

    fun mergeFrom(otherDeck: DeckEntity) {
        if (name != otherDeck.name) {
            name = otherDeck.name
        }
        if (size != otherDeck.size) {
            size = otherDeck.size
        }
        if (black != otherDeck.black) {
            black = otherDeck.black
        }
        if (white != otherDeck.white) {
            white = otherDeck.white
        }
        if (green != otherDeck.green) {
            green = otherDeck.green
        }
        if (red != otherDeck.red) {
            red = otherDeck.red
        }
        if (blue != otherDeck.blue) {
            blue = otherDeck.blue
        }
    }
}