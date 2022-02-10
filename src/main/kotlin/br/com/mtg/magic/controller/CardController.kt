package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CardController(
    @Autowired private var cardBusiness: CardBusiness
) {
    @RequestMapping(value = ["/cards"], method = [(RequestMethod.GET)])
    fun getCards(): ResponseEntity<List<Card>> {
        val model = cardBusiness.getAllCards()
        return ResponseEntity(model, HttpStatus.OK)
    }

    @RequestMapping(value = ["/cards"], method = [(RequestMethod.POST)])
    fun createCard(@RequestBody card: Card): ResponseEntity<Card> {
        val persistedCard = cardBusiness.createCard(card)
        return ResponseEntity(persistedCard, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/cards/{cardId}"], method = [(RequestMethod.GET)])
    fun getCardById(@PathVariable(value = "cardId") cardId: Long): ResponseEntity<Card> {
        val card = cardBusiness.getCardById(cardId)
        return ResponseEntity(card, HttpStatus.OK)
    }

    @RequestMapping(value = ["/cards/{cardId}"], method = [(RequestMethod.DELETE)])
    fun deleteCardById(@PathVariable(value = "cardId") cardId: Long): ResponseEntity<Card> {
        val noLongerCard = cardBusiness.deleteCard(cardId)
        return ResponseEntity(noLongerCard, HttpStatus.OK)
    }
    @RequestMapping(value = ["cards/{CardId}"], method = [RequestMethod.PUT])
    fun editCardById(@RequestBody Card: Card, @PathVariable(value = "CardId") CardId: Long): ResponseEntity<Card> {
        val alteredCard = cardBusiness.editCard(Card, CardId)
        return ResponseEntity(alteredCard, HttpStatus.OK)
    }

}