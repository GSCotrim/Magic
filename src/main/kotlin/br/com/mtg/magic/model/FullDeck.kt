package br.com.mtg.magic.model

import br.com.mtg.magic.Deck

data class FullDeck (
    var deck: Deck,
    var cards: List<CardInDeck>
        )
