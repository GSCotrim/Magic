package br.com.mtg.magic

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Intern(
    @Autowired private var jedisHandler: JedisHandler,
    @Autowired private var deckRepository: DeckRepository,
    @Autowired private var cardRepository: CardRepository,
    private val log: Logger = LoggerFactory.getLogger(CardBusiness::class.java)
) {
    fun checkAndStashCard(cardId: Long): Card {
        val cardEntity = cardRepository.findById(cardId).orElseThrow { CardNotFoundException() }
        val cacheItem = jedisHandler.getCard(cardEntity)
        if (cacheItem != null) {
            log.info("$cacheItem already exists.")
        } else {
            jedisHandler.storingCardNameRedis(cardEntity)
            log.info("Card ID ${cardEntity.id} was registered.")
        }
        return Card.fromEntity(cardEntity)
    }

    fun checkAndStashDeck(deckId: Long): Deck {
        val deckEntity = deckRepository.findById(deckId).orElseThrow { DeckNotFoundException() }
        val cacheItem = jedisHandler.getDeck(deckEntity)
        if (cacheItem != null) {
            log.info("$cacheItem already exists.")
        } else {
            jedisHandler.storingDeckNameRedis(deckEntity)
            log.info("Deck ID ${deckEntity.id} was registered.")
        }
        return Deck.fromEntity(deckEntity)
    }

    fun helpingCreateDeck(deck: Deck): Deck {
        val entity = deck.toEntity()
        val persistedDeck = deckRepository.save(entity)
        return Deck.fromEntity(persistedDeck)
    }

//    fun meDaUmDeck(deckId): Deck {
//        //preciso de um deck...
//        deck = redis.getDeck()
//        if consegui meu deck {
//            return deck
//        } else {
//            //puts, não estava no cache. Vamos ter que fazer uma operação mais demorada
//            deckEntity = bancoDeDados.getDeck()
//            deck = deck.fromEntity(deckEntity)
//            //vamos por no Redis para não ter problema da próxima vez
//            redis.setDeck(deck)
//        }
//        return deck
//    }
}