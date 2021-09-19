package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class DeckController(@Autowired private var deckBusiness: DeckBusiness) {
    @RequestMapping(value = ["/decks"], method = [(RequestMethod.GET)])
    fun getDecks(): ResponseEntity<Deck> {

        val model = deckBusiness.deckPrinter()
        return ResponseEntity(model, HttpStatus.OK)
    }

}