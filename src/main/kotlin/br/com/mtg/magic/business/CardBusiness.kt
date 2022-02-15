package br.com.mtg.magic

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import redis.clients.jedis.Jedis

@Component
class CardBusiness(
    @Autowired private var profile: ProfileInterface,
    @Autowired private var cardRepository: CardRepository,
    @Autowired private var jedisHandler: JedisHandler,
    private val log: Logger = LoggerFactory.getLogger(CardBusiness::class.java)
) {
    fun getAllCards(): List<Card> {
        val entities = cardRepository.findAll()
        return entities.map { Card.fromEntity(it) }
    }
    fun getCardById(cardId: Long): Card {
        log.info("Looking for card with id: $cardId")
        log.info(profile.helloWorld())
        val entity = cardRepository.findById(cardId).orElseThrow { CardNotFoundException() }
        jedisHandler.storingCardNameRedis(entity)
        return Card.fromEntity(entity)
    }
    fun createCard(card: Card): Card {
        val entity = card.toEntity()
        val persistedCard = cardRepository.save(entity)
        return Card.fromEntity(persistedCard)
    }
    fun deleteCard(cardId: Long): Card {
        val entity = cardRepository.findById(cardId).orElseThrow { CardNotFoundException() }
        cardRepository.delete(entity)
        return Card.fromEntity(entity)
    }

    fun editCard(card: Card, cardId: Long): Card {
        val entity = card.toEntity()
        entity.id = cardId
        cardRepository.save(entity)
        return Card.fromEntity(entity)
    }

    fun partialEditCard(card: Card, cardId: Long): Card {
        val dataBaseEntity = cardRepository.findById(cardId).orElseThrow{ CardNotFoundException() }
        val entity = card.toEntity()
        dataBaseEntity.mergeFrom(entity)
        cardRepository.save(dataBaseEntity)
        return Card.fromEntity(dataBaseEntity)
    }

    // fun nomeDaFuncao(nomeDaVariavel: TipoDaVariavel): TipoDoRetornoDaFuncao {}
    // TipoDoRetornoDaFuncao nomeDaFuncao(TipoDaVariavel nomeDaVariavel) {}
    // fun soma(x: int, y: int): int {}
    // int soma(int x, int y) {}

//    fun blabla(): Card{
//        cardRepository.findAll()
//    }
}
