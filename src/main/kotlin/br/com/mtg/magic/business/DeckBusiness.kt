package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeckBusiness(
    @Autowired private var deckRepository: DeckRepository,
    @Autowired private var jedisHandler: JedisHandler
) {
    fun getAllDecks(): List<Deck> {
        val entities = deckRepository.findAll()
        return entities.map {Deck.fromEntity(it)}
    }
    fun getDeckById(deckId: Long): Deck {
        val entity = deckRepository.findById(deckId).orElseThrow { DeckNotFoundException() }
        jedisHandler.storingDeckNameRedis(entity)
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