package br.com.mtg.magic

data class Deck(
    var name: String,
    var size: Int,
    var deckCards: List<Card>

){
    companion object{
        fun testDeck(): Deck{
            return Deck(
                    name = "Primeiro Deck",
                    size = 3,
                    deckCards = listOf(Card.testCard(), Card.testCard(), Card.testCard())
            )
        }
    }
}