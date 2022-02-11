package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class DeckCardController(
    @Autowired private var deckCardBusiness: DeckCardBusiness
) {
    @RequestMapping(value = ["/deckcards"], method = [(RequestMethod.POST)])
    fun createDeckCard(@RequestBody deckCard: DeckCard): ResponseEntity<DeckCard> {
        val persistedDeckCard = deckCardBusiness.createDeckCard(deckCard)
        return ResponseEntity(persistedDeckCard, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/deckcards/{deckCardId}"], method = [(RequestMethod.DELETE)])
    fun deleteDeckCardById(@PathVariable(value = "deckCardId") deckCardId: Long): ResponseEntity<DeckCard> {
        val noLongerDeckCard = deckCardBusiness.deleteDeckCard(deckCardId)
        return ResponseEntity(noLongerDeckCard, HttpStatus.OK)
    }

    @RequestMapping(value = ["deckcards/{deckCardId}"], method = [RequestMethod.PUT])
    fun editDeckCardById(@RequestBody deckCard: DeckCard, @PathVariable(value = "deckCardId") deckCardId: Long): ResponseEntity<DeckCard> {
        val alteredDeckCard = deckCardBusiness.editDeckCard(deckCard, deckCardId)
        return ResponseEntity(alteredDeckCard, HttpStatus.OK)
    }

    @RequestMapping(value = ["deckcards/{deckCardId}"], method = [RequestMethod.PATCH])
    fun partialEditDeckCardById(@RequestBody deckCard: DeckCard, @PathVariable(value = "deckCardId") deckCardId: Long): ResponseEntity<DeckCard> {
        val partiallyAlteredDeckCard = deckCardBusiness.partialEditDeckCard(deckCard, deckCardId)
        return ResponseEntity(partiallyAlteredDeckCard, HttpStatus.OK)
    }
}

