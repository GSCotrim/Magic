package br.com.mtg.magic

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CardBusiness(
    @Autowired private var cardRepository: CardRepository,
    private val log: Logger = LoggerFactory.getLogger(CardBusiness::class.java)
) {
    fun getAllCards(): List<Card> {
        val entities = cardRepository.findAll()
        return entities.map { Card.fromEntity(it) }
    }
    fun getCardById(cardId: Long): Card {
        log.info("Looking for card with id: $cardId")
        val entity = cardRepository.findById(cardId).orElseThrow { CardNotFoundException() }
        return Card.fromEntity(entity)
    }
    fun createCard(card: Card): Card {
        val entity = card.toEntity()
        val persistedCard = cardRepository.save(entity)
        return Card.fromEntity(persistedCard)
    }

    // fun nomeDaFuncao(nomeDaVariavel: TipoDaVariavel): TipoDoRetornoDaFuncao {}
    // TipoDoRetornoDaFuncao nomeDaFuncao(TipoDaVariavel nomeDaVariavel) {}
    // fun soma(x: int, y: int): int {}
    // int soma(int x, int y) {}

//    fun blabla(): Card{
//        cardRepository.findAll()
//    }
}