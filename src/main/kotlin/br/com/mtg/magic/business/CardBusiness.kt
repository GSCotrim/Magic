package br.com.mtg.magic

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CardBusiness(
    @Autowired private var profile: ProfileInterface,
    @Autowired private var intern: Intern,
    private val log: Logger = LoggerFactory.getLogger(CardBusiness::class.java)
) {
    fun getAllCards(): List<Card> {
        val cardList = intern.helpingGetAllCards()
        return cardList
    }

    fun getCardById(cardId: Long): Card {
        log.info("Looking for card with id: $cardId")
        val card = intern.checkAndStashCard(cardId)
        return card
    }

    fun createCard(card: Card): Card {
        val isThisYourCard = intern.helpingCreateCards(card)
        return isThisYourCard
    }

    fun deleteCard(cardId: Long): Card {
        val vaporizedCard = intern.iCanDeleteCardsForYou(cardId)
        return vaporizedCard
    }

    fun editCard(card: Card, cardId: Long): Card {
        val editedCard = intern.justEditTheCard(card, cardId)
        return editedCard
    }

    fun partialEditCard(card: Card, cardId: Long): Card {
        val partiallyEditedCard = intern.justASliceOfCard(card, cardId)
        return partiallyEditedCard
    }

    // fun nomeDaFuncao(nomeDaVariavel: TipoDaVariavel): TipoDoRetornoDaFuncao {}
    // TipoDoRetornoDaFuncao nomeDaFuncao(TipoDaVariavel nomeDaVariavel) {}
    // fun soma(x: int, y: int): int {}
    // int soma(int x, int y) {}

//    fun blabla(): Card{
//        cardRepository.findAll()
//    }
}



