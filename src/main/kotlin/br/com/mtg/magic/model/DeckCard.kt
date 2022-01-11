package br.com.mtg.magic

data class DeckCard(

    var id: Long?,
    var deckId: Long,
    var cardId: Long,
    var amount: Long
){
    companion object{
        fun testDeckCard(): DeckCard {
            return br.com.mtg.magic.DeckCard(
                id = 1,
                deckId = 100,
                cardId = 5,
                amount = 60
            )
        }
        fun fromEntity(entity: DeckCardEntity): DeckCard {
            return br.com.mtg.magic.DeckCard(
                entity.id, entity.deckId, entity.cardId, entity.amount
            )
        }
    }
    fun toEntity(): DeckCardEntity {
        return DeckCardEntity(
            id,
            deckId,
            cardId,
            amount
        )
    }

}