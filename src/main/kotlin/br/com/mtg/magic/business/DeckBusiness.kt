package br.com.mtg.magic

import br.com.mtg.magic.model.CardInDeck
import br.com.mtg.magic.model.FullDeck
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeckBusiness(

    @Autowired private var cardRepository: CardRepository,
    @Autowired private var deckCardRepository: DeckCardRepository,
    @Autowired private var deckRepository: DeckRepository,
    @Autowired private var intern: Intern,
    private val log: Logger = LoggerFactory.getLogger(CardBusiness::class.java)
) {

    fun getAllDecks(): List<Deck> {
        val deckList = intern.helpingGetAllDecks()
        return deckList
    }

    fun getDeckById(deckId: Long): Deck {
        log.info("Looking for deck with id: $deckId")
        val deck = intern.checkAndStashDeck(deckId)
        return deck
    }

//    fun getDeck(deckId: Long): Deck {
//        log.info("Looking for deck with id: $deckId")
//        foo.meDaUmDeck(idDeck)
//        return Deck.fromEntity(entity)
//    }

    fun createDeck(deck: Deck): Deck {
        val createdDeck = intern.helpingCreateDeck(deck)
        return createdDeck
    }

    fun deleteDeck(deckId: Long): Deck {
        val vaporizedDeck = intern.iCanDeleteDecksForYou(deckId)
        return vaporizedDeck
    }

    fun editDeck(deck: Deck, deckId: Long): Deck {
        val editedDeck = intern.justEditTheDeck(deck, deckId)
        return editedDeck
    }

    fun partialEditDeck(deck: Deck, deckId: Long): Deck {
        val partiallyEditedDeck = intern.justASliceOfDeck(deck, deckId)
        return partiallyEditedDeck
    }

    fun getAllCardsFromDeck(deckId: Long): FullDeck {
        val deck = getDeckById(deckId)
        val cardsList = mutableListOf<CardInDeck>()
        val deckCardsList = deckCardRepository.findAllByDeckId(deckId).orElse(listOf())
        deckCardsList.forEach {
            val entity = cardRepository.findById(it.cardId).orElseThrow { CardNotFoundException() }
            val card = Card.fromEntity(entity)
            val cardInDeck = CardInDeck(card, it.amount)
            cardsList.add(cardInDeck)
        }
        val fullDeck = FullDeck(deck, cardsList)

        return fullDeck
    }
}