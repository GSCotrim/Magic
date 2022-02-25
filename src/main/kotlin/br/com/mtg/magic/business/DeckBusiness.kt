package br.com.mtg.magic

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeckBusiness(
    @Autowired private var deckRepository: DeckRepository,
    @Autowired private var jedisHandler: JedisHandler,
    private val log: Logger = LoggerFactory.getLogger(CardBusiness::class.java)
) {

    fun getAllDecks(): List<Deck> {
        val entities = deckRepository.findAll()
        return entities.map {Deck.fromEntity(it)}
    }

    fun getDeckById(deckId: Long): Deck {
        log.info("Looking for deck with id: $deckId")
        val entity = deckRepository.findById(deckId).orElseThrow { DeckNotFoundException() }
        val cacheItem = jedisHandler.getDeck(entity)
        if (cacheItem != null) {
            log.info("$cacheItem already exists.")
        }
        else {
            jedisHandler.storingDeckNameRedis(entity)
            log.info("Deck ID ${entity.id} was registered.")
        }
        return Deck.fromEntity(entity)
    }

    fun createDeck(deck: Deck): Deck {
        val entity = deck.toEntity()
        val persistedDeck = deckRepository.save(entity)
        return Deck.fromEntity(persistedDeck)
    }

    fun deleteDeck(deckId: Long): Deck {
        val entity = deckRepository.findById(deckId).orElseThrow { DeckNotFoundException() }
        deckRepository.delete(entity)
        return Deck.fromEntity(entity)
    }

    fun editDeck(deck: Deck, deckId: Long): Deck {
        val entity = deck.toEntity()
        entity.id = deckId
        deckRepository.save(entity)
        return Deck.fromEntity(entity)
    }

    fun partialEditDeck(deck: Deck, deckId: Long): Deck {
        val dataBaseEntity = deckRepository.findById(deckId).orElseThrow{ DeckNotFoundException() }
        val entity = deck.toEntity()
        dataBaseEntity.mergeFrom(entity)
        deckRepository.save(dataBaseEntity)
        return Deck.fromEntity(dataBaseEntity)
    }
}