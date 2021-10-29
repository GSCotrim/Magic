package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
class DeckCardController(
    @Autowired private var deckCardBusiness: DeckCardBusiness
) {

}