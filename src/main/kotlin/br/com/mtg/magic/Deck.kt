package br.com.mtg.magic

data class Deck(
    var id: Long?,
    var name: String,
    var size: Int

){
    companion object{
        fun testDeck(): Deck{
            return Deck(
                    id = 1,
                    name = "Primeiro Deck",
                    size = 3,
//                    deckCards = listOf(Card.testCard(), Card.testCard(), Card.testCard())
            )
        }
    }
}