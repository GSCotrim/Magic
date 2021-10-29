package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CardBusiness(
    @Autowired private var cardRepository: CardRepository
) {
    fun justPrint(): Card {
        return Card.testCard()
    }
    fun getCardById(cardId: Long): Card {
        val entity = cardRepository.findById(cardId).orElseThrow { CardNotFoundException() }
        return Card.fromEntity(entity)
    }
    fun createCard(card: Card): Card {
        val entity = card.toEntity()
        val persistedCard = cardRepository.save(entity)
        return Card.fromEntity(persistedCard)
    }
//    fun blabla(): Card{
//        cardRepository.findAll()
//    }
}
