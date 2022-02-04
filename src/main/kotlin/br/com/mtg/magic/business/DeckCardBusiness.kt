package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeckCardBusiness(
    @Autowired private var deckCardRepository: DeckCardRepository,
    @Autowired private var cardRepository: CardRepository,
    @Autowired private var deckRepository: DeckRepository
) {

    fun createDeckCard(deckCard: DeckCard): DeckCard{
        if (cardRepository.existsById(deckCard.cardId) && deckRepository.existsById(deckCard.deckId)){
            if (validateCardAmount(deckCard.deckId, deckCard.amount)) {
                val entity = deckCard.toEntity()
                val persistedDeckCard = deckCardRepository.save(entity)
                return DeckCard.fromEntity(persistedDeckCard)
            }
            else {
                throw TooManyCardsInDeckException()
            }
        }
        else{
            throw DeckCardTemporaryException()
        }
    }
    fun validateCardAmount(deckId: Long, currentAmount: Long): Boolean{
        val deckCardsList = deckCardRepository.findAllByDeckId(deckId).orElse(listOf())
        var counter = currentAmount
        deckCardsList.forEach { counter += it.amount }
        return counter <= 75
    }
}