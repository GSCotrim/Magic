package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DeckCardController(
    @Autowired private var deckCardBusiness: DeckCardBusiness
) {
    @RequestMapping(value = ["/deckcards"], method = [(RequestMethod.POST)])
    fun createDeckCard(@RequestBody deckCard: DeckCard): ResponseEntity<DeckCard> {
        val persistedDeckCard = deckCardBusiness.createDeckCard(deckCard)
        return ResponseEntity(persistedDeckCard, HttpStatus.CREATED)
    }
}