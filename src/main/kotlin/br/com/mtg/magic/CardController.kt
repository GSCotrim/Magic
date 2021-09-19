package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class CardController(@Autowired private var cardBusiness: CardBusiness) {

    @RequestMapping(value = ["/cards"], method = [(RequestMethod.GET)])
    fun getCards(): ResponseEntity<Card> {

        val model = cardBusiness.justPrint()
        return ResponseEntity(model, HttpStatus.OK)

    }

}