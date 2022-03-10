package br.com.mtg.magic

import br.com.mtg.magic.model.FullDeck
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DeckController(
    @Autowired private var deckBusiness: DeckBusiness
) {
    @RequestMapping(value = ["/decks"], method = [(RequestMethod.GET)])
    fun getDecks(): ResponseEntity<List<Deck>> {
        val model = deckBusiness.getAllDecks()
        return ResponseEntity(model, HttpStatus.OK)
    }

    @RequestMapping(value = ["/decks/{deckId}"], method = [(RequestMethod.GET)])
    fun getDeckById(@PathVariable(value = "deckId") deckId: Long): ResponseEntity<Deck> {
        val deck = deckBusiness.getDeckById(deckId)
        return ResponseEntity(deck, HttpStatus.OK)
    }

    @RequestMapping(value = ["/decks"], method = [(RequestMethod.POST)])
    fun createDeck(@RequestBody deck: Deck): ResponseEntity<Deck> {
        val persistedDeck = deckBusiness.createDeck(deck)
        return ResponseEntity(persistedDeck, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/decks/{deckId}"], method = [(RequestMethod.DELETE)])
    fun deleteDeckById(@PathVariable(value = "deckId") deckId: Long): ResponseEntity<Deck> {
        val noLongerDeck = deckBusiness.deleteDeck(deckId)
        return ResponseEntity(noLongerDeck, HttpStatus.OK)
    }

    @RequestMapping(value = ["decks/{deckId}"], method = [RequestMethod.PUT])
    fun editDeckById(@RequestBody deck: Deck, @PathVariable(value = "deckId") deckId: Long): ResponseEntity<Deck> {
        val alteredDeck = deckBusiness.editDeck(deck, deckId)
        return ResponseEntity(alteredDeck, HttpStatus.OK)
    }

    @RequestMapping(value = ["decks/{deckId}"], method = [RequestMethod.PATCH])
    fun partialEditDeckById(@RequestBody deck: Deck, @PathVariable(value = "deckId") deckId: Long): ResponseEntity<Deck> {
        val partiallyAlteredDeck = deckBusiness.partialEditDeck(deck, deckId)
        return ResponseEntity(partiallyAlteredDeck, HttpStatus.OK)
    }

    @RequestMapping(value = ["decks/{deckId}/full"], method = [RequestMethod.GET])
    fun showDeckCardsById(@PathVariable(value = "deckId") deckId: Long): ResponseEntity<FullDeck> {
        val fullDeck = deckBusiness.getAllCardsFromDeck(deckId)
        return ResponseEntity(fullDeck, HttpStatus.OK)

    }
}
