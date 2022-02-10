package br.com.mtg.magic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DeckCardBusiness(
    @Autowired private var deckCardRepository: DeckCardRepository,
    @Autowired private var cardRepository: CardRepository,
    @Autowired private var deckRepository: DeckRepository
) {

    fun createDeckCard(deckCard: DeckCard): DeckCard{
        if (cardRepository.existsById(deckCard.cardId) && deckRepository.existsById(deckCard.deckId)){
            if (validateCardAmount(deckCard.deckId, deckCard.amount)) {
                val entity = deckCard.toEntity()
                val persistedDeckCard = deckCardRepository.save(entity)
                return DeckCard.fromEntity(persistedDeckCard)
            }
            else {
                throw TooManyCardsInDeckException()
            }
        }
        else{
            throw DeckCardTemporaryException()
        }
    }

//    Deleta todas as ocorrências de uma determinada carta, associadas a um deckCardId.
    fun deleteDeckCard(deckCardId: Long): DeckCard {
        val entity = deckCardRepository.findById(deckCardId).orElseThrow { DeckCardNotFoundException() }
        deckCardRepository.delete(entity)
        return DeckCard.fromEntity(entity)
    }

    fun editDeckCard(deckCard: DeckCard, deckCardId: Long): DeckCard {
        val entity = deckCard.toEntity()
        entity.id = deckCardId
        deckCardRepository.save(entity)
        return DeckCard.fromEntity(entity)
    }

//    fun partialEditDeckCard(deckCard: DeckCard, deckCardId: Long, alteredProperty: String, change: Long): DeckCard {
//        val entity = deckCard.toEntity()
//        val smallAlteredProperty = alteredProperty.lowercase()
//        entity.id = deckCardId
//        if (smallAlteredProperty == "deckid") {
//            entity.deckId = change
//        }
//        else if (smallAlteredProperty == "cardid") {
//            entity.cardId = change
//        }
//        else if (smallAlteredProperty == "amount") {
//            entity.amount = change
//        }
////        else
////            Throw{ DeckCardPropertyNotFoundException() }
//        deckCardRepository.save(entity)
//        return DeckCard.fromEntity(entity)
//    }

    fun partialEditDeckCard(deckCard: DeckCard, deckCardId: Long): DeckCard {
        val dataBaseEntity = deckCardRepository.findById(deckCardId).orElseThrow{ DeckCardNotFoundException() }
        val entity = deckCard.toEntity()

        if (entity.deckId != dataBaseEntity.deckId) {
            dataBaseEntity.deckId = entity.deckId
        }
        else if (entity.cardId != dataBaseEntity.cardId) {
            dataBaseEntity.cardId = entity.cardId
        }
        else if (entity.amount != dataBaseEntity.amount) {
            dataBaseEntity.amount = entity.amount
        }

        deckCardRepository.save(dataBaseEntity)
        return DeckCard.fromEntity(dataBaseEntity)
    }

    fun validateCardAmount(deckId: Long, currentAmount: Long): Boolean{
        val deckCardsList = deckCardRepository.findAllByDeckId(deckId).orElse(listOf())
        var counter = currentAmount
        deckCardsList.forEach { counter += it.amount }
        return counter <= 75
    }
}