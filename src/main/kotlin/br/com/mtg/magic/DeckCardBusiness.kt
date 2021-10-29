package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeckCardBusiness(
    @Autowired private var deckCardRepository: DeckCardRepository
) {

}