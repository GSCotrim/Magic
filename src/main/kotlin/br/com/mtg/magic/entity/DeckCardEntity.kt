package br.com.mtg.magic

import javax.persistence.*

@Entity
@Table(name = "deckCards")
data class DeckCardEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,

    @Column
    var deckId: Long,
    @Column
    var cardId: Long,
    @Column
    var amount: Long

) {
    companion object;
    constructor() : this(null, 0, 0, 0)

    fun mergeFrom(otherDeckCard: DeckCardEntity) {
        if (deckId != otherDeckCard.deckId) {
            deckId = otherDeckCard.deckId
        }
        if (cardId != otherDeckCard.cardId) {
            cardId = otherDeckCard.cardId
        }
        if (amount != otherDeckCard.amount) {
            amount = otherDeckCard.amount
        }
    }
}

