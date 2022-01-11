package br.com.mtg.magic

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
}

