package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeckBusiness(
    @Autowired private var deckRepository: DeckRepository
) {
    fun deckPrinter(): Deck {
        return Deck.testDeck()
    }
    fun getDeckById(deckId: Long): Deck {
        val entity = deckRepository.findById(deckId).orElseThrow { DeckNotFoundException() }
        return Deck.fromEntity(entity)
    }
    fun createDeck(deck: Deck): Deck {
        val entity = deck.toEntity()
        val persistedDeck = deckRepository.save(entity)
        return Deck.fromEntity(persistedDeck)
    }
}