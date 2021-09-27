package br.com.mtg.magic

import org.springframework.stereotype.Component

@Component
class DeckBusiness {
    fun deckPrinter(): Deck {
        return Deck.testDeck()
    }
}