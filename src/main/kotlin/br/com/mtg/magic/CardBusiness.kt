package br.com.mtg.magic

import org.springframework.stereotype.Component

@Component
class CardBusiness {

    fun justPrint(): Card {
        return Card.testCard()
    }
}
